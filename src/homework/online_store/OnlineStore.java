package homework.online_store;

import homework.online_store.model.Order;
import homework.online_store.model.Product;
import homework.online_store.model.User;
import homework.online_store.storage.OrderStorage;
import homework.online_store.storage.ProductStorage;
import homework.online_store.storage.UserStorage;
import work.RandomStringGenerator;

import java.util.Date;
import java.util.Scanner;

import static homework.online_store.OrderStatus.DELIVERED;


public class OnlineStore implements OnlineStoreCommands {

    static Scanner scanner = new Scanner(System.in);
    static User user;
    static UserStorage userStorage = new UserStorage();
    static ProductStorage productStorage = new ProductStorage();
    static OrderStorage orderStorage = new OrderStorage();

    public static void main(String[] args) {
        OnlineStoreCommands.LoginOrRegister();
        switch (scanner.nextLine()) {
            case LOGIN:
                loginUser();
                break;
            case REGISTER:
                registerUser();

        }

        switch (user.getUserType()) {
            case ADMIN:
                boolean startAdmin = true;
                while (startAdmin) {
                    OnlineStoreCommands.adminCommands();
                    switch (scanner.nextLine()) {
                        case LOGOUT:
                            startAdmin = false;
                            break;
                        case ADD_PRODUCT:
                            addProduct();
                            break;
                        case REMOVE_PRODUCT_BY_ID:
                            removeProductById();
                            break;
                        case PRINT_PRODUCTS:
                            productStorage.print();
                            break;
                        case PRINT_USERS:
                            userStorage.print();
                            break;
                        case PRINT_ORDERS:
                            orderStorage.print();
                            break;
                        case CHANG_ORDER_STATUS:
                            changOrderStatus();
                            break;
                    }
                }
            case USER:
                boolean startUser = true;
                while (startUser) {
                    OnlineStoreCommands.userCommands();
                    switch (scanner.nextLine()) {
                        case LOGOUT:
                            startUser = false;
                            break;
                        case PRINT_ALL_PRODUCTS:
                            productStorage.print();
                            break;
                        case BUY_PRODUCT:
                            buyProduct();
                            break;
                        case PRINT_MY_ORDERS:
                            orderStorage.printByUser(user);
                            break;
                        case CANCEL_ORDER_BY_ID:
                            cancelOrderById();
                            break;
                    }
                }

        }
    }

    private static void changOrderStatus() {
        orderStorage.changeStatus();
    }

    private static void cancelOrderById() {
        System.out.println("Please input the order id");
        String orderId = scanner.nextLine();
        orderStorage.cancelById(orderId);
    }

    private static void buyProduct()
    {
        System.out.println("Please input the product id");
        String productId = scanner.nextLine();
        Product product = productStorage.searchById(productId);
        System.out.println("Please input the product qty");
        int qty = Integer.parseInt(scanner.nextLine());
        try {
            product.checkQty(qty);
        }catch (OutOfStockException e)
        {
            System.out.println("There are not many items in stock");
        }
        PaymentMethod[] paymentMethods = PaymentMethod.values();
        for (PaymentMethod paymentMethod : paymentMethods){
            System.out.print(paymentMethod);
        }
        System.out.println("Please choose one of the payment methods");
        PaymentMethod paymentMethod = PaymentMethod.valueOf((scanner.nextLine()).toUpperCase());
        double price = product.getPrice();
        price *= qty;
        System.out.println("The price of the product is " + price + "$" + " do you want to buy?");
        System.out.println("Please input yes or no");
        String answer = scanner.nextLine();
        if (answer.equals("yes")){
            Date date = new Date();
            String orderId = RandomStringGenerator.generateRandomString(30);
            orderStorage.add(new Order(orderId, user, product, date, price, DELIVERED, qty, paymentMethod ));
        }else {
            System.out.println("Purchase cancelled");
        }
    }

    private static void removeProductById() {
        productStorage.print();
        System.out.println("Please input the product id which you want to remove");
        String productId = scanner.nextLine();
        productStorage.deleteById(productId);
    }

    private static void addProduct() {
        System.out.println("Please input the product id");
        String productId = scanner.nextLine();
        System.out.println("Please input the product name");
        String productName = scanner.nextLine();
        System.out.println("Please input the product description");
        String productDescription = scanner.nextLine();
        System.out.println("Please input the product price");
        double productPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input the product stock quantity");
        int productStockQuantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Please choose the product type");
        Type[] types = Type.values();
        for (Type type : types) {
            System.out.println(type);
        }
        System.out.println("Please input the product type");
        Type type = Type.valueOf((scanner.nextLine()).toUpperCase());

        productStorage.add(new Product(productId, productName, productDescription, productPrice, productStockQuantity, type));

    }

    private static void registerUser() {
        System.out.println("Please input the user id");
        String userId = scanner.nextLine();
        System.out.println("Please input the user name");
        String userName = scanner.nextLine();
        System.out.println("Please input the user email");
        String email = scanner.nextLine();
        System.out.println("Please input the account password");
        String password = scanner.nextLine();
        System.out.println("Please input user type");
        UserType[] userTypes = UserType.values();
        for (UserType userType : userTypes) {
            System.out.println(userType);
        }
        UserType userType = UserType.valueOf((scanner.nextLine()).toUpperCase());
        user = new User(userId, userName, email, password, userType);
        userStorage.add(user);

    }

    private static void loginUser() {
        System.out.println("Please input your email address");
        String email = scanner.nextLine();
        System.out.println("Please input your password");
        String password = scanner.nextLine();
        user = userStorage.searchUserByEmail(password);

    }
}
