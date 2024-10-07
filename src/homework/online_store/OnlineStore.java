package homework.online_store;

import homework.online_store.Enum.PaymentMethod;
import homework.online_store.Enum.Type;
import homework.online_store.Enum.UserType;
import homework.online_store.Exception.OutOfStockException;
import homework.online_store.Interface.OnlineStoreCommands;
import homework.online_store.model.Order;
import homework.online_store.model.Product;
import homework.online_store.model.User;
import homework.online_store.storage.OrderStorage;
import homework.online_store.storage.ProductStorage;
import homework.online_store.storage.UserStorage;
import work.RandomStringGenerator;

import java.util.Date;
import java.util.Scanner;

import static homework.online_store.Enum.OrderStatus.NEW;


public class OnlineStore implements OnlineStoreCommands {

    static Scanner scanner = new Scanner(System.in);
    static User user;
    static UserStorage userStorage = new UserStorage();
    static ProductStorage productStorage = new ProductStorage();
    static OrderStorage orderStorage = new OrderStorage();

    public static void main(String[] args) {
        deserializeData();
        boolean start = true;

        while (start) {
            OnlineStoreCommands.LoginOrRegister();
            switch (scanner.nextLine()) {
                case LOGOUT:
                    start = false;
                    break;
                case LOGIN:
                    loginUser();
                    break;
                case REGISTER:
                    registerUser();
                    break;


            }
            if (user != null) {
                storeStart();
            }
        }


    }

    private static void deserializeData() {
        userStorage.deserializeUsers();
        productStorage.deserializeProducts();
        orderStorage.deserializeOrders();
    }

    private static void storeStart() {
        switch (user.getUserType()) {
            case ADMIN:
                System.out.print(user.getUserType());
                boolean startAdmin = true;
                while (startAdmin) {
                    OnlineStoreCommands.adminCommands();
                    switch (scanner.nextLine()) {
                        case LOGOUT:
                            user = null;
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
                break;
            case USER:
                boolean startUser = true;
                while (startUser) {
                    OnlineStoreCommands.userCommands();
                    switch (scanner.nextLine()) {
                        case LOGOUT:
                            user = null;
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
                break;

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

    private static void buyProduct() {
        System.out.println("Please input the product id");
        String productId = scanner.nextLine();
        Product product = productStorage.searchById(productId);
        System.out.println("Please input the product qty");
        int qty = Integer.parseInt(scanner.nextLine());
        try {
            product.checkQty(qty);
            PaymentMethod[] paymentMethods = PaymentMethod.values();
            for (PaymentMethod paymentMethod : paymentMethods) {
                System.out.print(paymentMethod);
            }
            System.out.println("Please choose one of the payment methods");
            PaymentMethod paymentMethod = PaymentMethod.valueOf((scanner.nextLine()).toUpperCase());
            double price = product.getPrice();
            price *= qty;
            System.out.println("The price of the product is " + price + "$" + " do you want to buy?");
            System.out.println("Please input yes or no");
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                Date date = new Date();
                String orderId = RandomStringGenerator.generateRandomString(30);
                orderStorage.add(new Order(orderId, user, product, date, price, NEW, qty, paymentMethod));
                product.setStockQty(product.getStockQty() - qty);
                productStorage.uppFiles();
            } else {
                System.out.println("Purchase cancelled");
            }
        } catch (OutOfStockException e) {
            System.out.println("There are not many items in stock");
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
        Product product = productStorage.searchById(productId);
        if (product == null) {
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

            productStorage.add(new Product(productId, productName, productDescription,
                    productPrice, productStockQuantity, type));
        } else {
            System.out.println("Please input how many products you want to add?");
            int qty = Integer.parseInt(scanner.nextLine());
            product.setStockQty(product.getStockQty() + qty);
            productStorage.uppFiles();
        }


    }

    private static void registerUser() {
        System.out.println("Please input the user id");
        String userId = scanner.nextLine();
        if (userStorage.getById(userId) != null) {
            System.out.println("This id is busy");
            System.out.println("Registration is stopped");
            System.out.println();
            return;
        }
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
        user = userStorage.searchUserByEmail(email);

    }
}
