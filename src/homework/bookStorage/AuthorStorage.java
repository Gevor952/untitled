package homework.bookStorage;

public class AuthorStorage
{
    Author[] author;
    private Author[] Authors = new Author[10];
    private int size = 0;

    public void add(Author Author)
    {
        if(size == Authors.length)
        {
            extendStorage();
        }
        Authors[size++] = Author;
    }

    private void extendStorage()
    {
        Author[] temp = new Author[size * 2];
        System.arraycopy(Authors, 0, temp, 0, size);
        Authors = temp;
    }

    public void print()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println(Authors[i]);
        }
    }

    public void searchBYAuthorName(String keyword)
    {
        for (int i = 0; i < size; i++)
        {
            if(Authors[i].getName().contains(keyword))
            {
                System.out.println(Authors[i].getName());
            }
        }
    }

    public Author getAuthorById(String id)
    {
        for (int i = 0; i < size; i++)
        {
            if (Authors[i].getId().equals(id))
            {
                return Authors[i];
            }
        }
        return null;
    }

    public void deleteAuthor(String id)
    {
        for(int i = 0; i < size; i++)
        {
            if(Authors[i].getId().equals(id))
            {
                Author[] temp = new Author[(size - i) + 10];
                System.arraycopy(Authors, i + 1, temp, 0, size );
                System.arraycopy(temp, 0, Authors, i , size--);
            }
        }
    }



}
