package homework.bookStorage;

public class BookStorage
{
    private Book[] books = new Book[10];
    private int size = 0;

    public void add(Book book)
    {
        if(size == books.length)
        {
            extendStorage();
        }
        books[size++] = book;
    }

    private void extendStorage()
    {
        Book[] temp = new Book[size * 2];
        System.arraycopy(books, 0, temp, 0, size);
        books = temp;
    }

    public void print()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println(books[i]);
        }
    }

    public void searchBYBookName(String keyword)
    {
        for (int i = 0; i < size; i++)
        {
            if(books[i].getTitle().contains(keyword))
            {
                System.out.println(books[i].getTitle());
            }
        }
    }

    public Book getBookById(String id)
    {
        for (int i = 0; i < size; i++)
        {
            if (books[i].getId().equals(id))
            {
                return books[i];
            }
        }
        return null;
    }

    public void deleteBook(String id)
    {
        for(int i = 0; i < size; i++)
        {
            if(books[i].getId().equals(id))
            {
                Book[] temp = new Book[(size - i) + 10];
                System.arraycopy(books, i + 1, temp, 0, size );
                System.arraycopy(temp, 0, books, i , size--);
            }
        }
    }


    public void searchByPrice(double min, double max)
    {
        if(min > max)
        {
            double temp = min;
            min = max;
            max = temp;
        }
        for(int i = 0; i < size; i++)
        {
            if(books[i].getPrice() >= min && books[i].getPrice() <= max)
            {
                System.out.println(books[i]);
            }
        }

    }

    public void searchByAuthor(Author author)
    {
        for(int i = 0; i < size; i++)
        {
           if(books[i].getAuthor().equals(author))
           {
               System.out.println(books[i]);
           }
        }
    }
}
