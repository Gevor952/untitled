package homework.online_store.Interface;

public interface OnlineStoreCommands {

    String LOGIN = "0";
    String REGISTER = "1";

    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANG_ORDER_STATUS = "6";

    String PRINT_ALL_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";


    static void LoginOrRegister()
    {
        System.out.println("Please input " + LOGIN + " for login");
        System.out.println("Please input " + REGISTER + " for register");
    }

    static void adminCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + ADD_PRODUCT + " for add product");
        System.out.println("Please input " + REMOVE_PRODUCT_BY_ID + " for remove product");
        System.out.println("Please input " + PRINT_PRODUCTS + " for print products");
        System.out.println("Please input " + PRINT_USERS + " for print users");
        System.out.println("Please input " + PRINT_ORDERS + " for print orders");
        System.out.println("Please input " + CHANG_ORDER_STATUS + " for change order status");


    }

    static void userCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + PRINT_ALL_PRODUCTS + " for print all products");
        System.out.println("Please input " + BUY_PRODUCT + " for buy product");
        System.out.println("Please input " + PRINT_MY_ORDERS + " for print my orders");
        System.out.println("Please input " + CANCEL_ORDER_BY_ID + " for cancel order by user");

    }
}
