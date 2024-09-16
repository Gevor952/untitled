package homework.bookStorage;

import java.util.Objects;

public class Book
{
    private String id;
    private String title;
    private Author author;
    private double price;
    private int qty;


    public Book(){}

    public Book(String id, String title, Author author, double price, int qty)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getTitle()
    {
        return title;
    }

    public Author getAuthor()
    {
        return author;
    }

    public double getPrice()
    {
        return price;
    }

    public String getId()
    {
        return id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && qty == book.qty && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode()
    {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(author);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + qty;
        return result;
    }


    @Override
    public String toString()
    {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
