package homework.bookStorage;

import java.util.Scanner;

public class Library implements LibraryCommands
{
    static  Scanner scanner = new Scanner(System.in);
    static  BookStorage bookStorage = new BookStorage();
    static AuthorStorage authorStorage = new AuthorStorage();


    public static void main(String[] args)
    {
//        bookStorage.add(new Book("001", "Inferno", "Dan Brown ", 50, 100));
//        bookStorage.add(new Book("002", "Angels and Demons", "Dan Brown ", 80, 70));
//        bookStorage.add(new Book("002", "Inferno", "The Da Vinci Code", 40, 90));
        boolean isRun = true;
        while (isRun)
        {
            LibraryCommands.printCommands();
            String command = scanner.nextLine();

            switch (command)
            {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_AUTHOR:
                    addAuthors();
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case SEARCH_BOOK_BY_NAME:
                    searchBookName();
                    break;
                case UPDATE_BOOK:
                    updateBook();
                    break;
                case DELETE_BOOK:
                    deleteBook();
                    break;
                case SEARCH_BY_PRICE:
                    searchByPrice();
                    break;
                case SEARCH_BOOK_BY_AUTHOR:
                    searchBookByAuthor();
                default:
                    System.out.println("Wrong command");

            }

        }
    }

    private static void searchBookByAuthor()
    {
        authorStorage.print();
        System.out.println("Please choose author id");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if(author != null)
        {
        bookStorage.searchByAuthor(author);
        }
    }

    private static void addAuthors()
    {
        System.out.print("Please input id, name, surname, phone, age");
        String[] authorDataStr = scanner.nextLine().split(",");
        if(authorDataStr.length == 5)
        {
            if(authorStorage.getAuthorById(authorDataStr[0]) != null)
            {
                return;
            }
            Author author = new Author(authorDataStr[0], authorDataStr[1], authorDataStr[2], authorDataStr[3],
                    Integer.parseInt(authorDataStr[4]));
            authorStorage.add(author);
        }
    }

    private static void searchByPrice()
    {
        System.out.println("Please input min-max price");
        String[] price = (scanner.nextLine()).split("-");
        if(price.length == 2)
        {
            try
            {
                bookStorage.searchByPrice(Double.parseDouble(price[0]), Double.parseDouble(price[1]));
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please input only digit ");
            }

        }

    }

    private static void deleteBook()
    {
        bookStorage.print();
        System.out.println("Please input book id");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if(bookById == null)
        {
            System.out.println("Book with " + bookId + " id does not exist!!!!");
            return;
        }
        bookStorage.deleteBook(bookId);
    }

    private static void updateBook()
    {
        bookStorage.print();
        System.out.println("Please input book id");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if(bookById != null)
        {
            authorStorage.print();
            System.out.println("Please choose author id");
            String authorId = scanner.nextLine();
            Author author = authorStorage.getAuthorById(authorId);
            if(author != null)
            {
                System.out.println("Please input the title's of the book");
                String title = scanner.nextLine();
                System.out.println("Please input the price's of the book");
                String price = scanner.nextLine();
                System.out.println("Please input the qty of the book");
                String qty = scanner.nextLine();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
                if (title != null && !title.isEmpty())
                {
                    bookById.setTitle(title);
                }

                    bookById.setAuthor(author);

                if (price != null && !price.isEmpty())
                {
                    bookById.setPrice(Double.parseDouble(price));
                }
                if(!qty.isEmpty())
                {
                    bookById.setQty(Integer.parseInt(qty));
                }
                System.out.println("Update wos successfully");
            }


        }
        else
        {
            System.out.println("Book not found");
        }

    }

    private static void searchBookName()
    {
        System.out.println("Please input book keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBYBookName(keyword);
    }

    private static void addBook()
    {
        authorStorage.print();
        System.out.println("Please choose author id");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if(author != null)
        {
            System.out.println("Please input the id of the book");
            String id = scanner.nextLine();
            System.out.println("Please input the title of the book");
            String title = scanner.nextLine();
            System.out.println("Please input the price of the book");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input qty");
            int qty = Integer.parseInt(scanner.nextLine());
            Book bookById = bookStorage.getBookById(id);

            if (bookById == null)
            {
                bookStorage.add(new Book(id, title, author, price, qty));
                System.out.println("Book added");
            }
            else
            {
                System.out.println("Book with " + id + " already exists!");
            }
        }
        else
        {
            System.out.println("wrong author id");
        }

    }

}
