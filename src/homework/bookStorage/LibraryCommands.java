package homework.bookStorage;

public interface LibraryCommands
{
    String  EXIT = "0";
    String  ADD_BOOK = "1";
    String  PRINT_ALL_BOOKS = "2";
    String  SEARCH_BOOK_BY_NAME = "3";
    String  UPDATE_BOOK = "4";
    String  DELETE_BOOK = "5";
    String  SEARCH_BY_PRICE = "6";

    static void printCommands()
    {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " +ADD_BOOK  + " for ADD_BOOK");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for PRINT_ALL_BOOKS");
        System.out.println("Please input " + SEARCH_BOOK_BY_NAME + " for SEARCH_BOOK_BY_NAME");
        System.out.println("Please input " + UPDATE_BOOK  + " for UPDATE_BOOK");
        System.out.println("Please input " + DELETE_BOOK  + " for DELETE_BOOK");
        System.out.println("Please input " + SEARCH_BY_PRICE + " for SEARCH_BY_PRICE");
    }

}
