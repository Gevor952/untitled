package work.Stack;
import work.Stack.Brace;
public class Brace
{
    private char Brace;
    private int index;

    public Brace(char Brace, int index)
    {
        this.Brace = Brace;
        this.index = index;
    }

    public char getBrace()
    {
        return Brace;
    }

    public int getIndex()
    {
        return index;
    }
}
