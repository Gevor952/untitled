package homework.bookStorage;

import java.util.Objects;

public class Book
{
    private String id;
    private String title;
    private String author;
    private double price;
    private int qty;


    public Book(){}

    public Book(String id, String title, String author, double price,  int qty)
    {
        this.title = title;
        this.author = author;
        this.price = price;
        this.id = id;
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

    public String getAuthor()
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

    public void setAuthor(String author)
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
        return Double.compare(price, book.price) == 0 && qty == book.qty && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(title, author, price, id, qty);
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
