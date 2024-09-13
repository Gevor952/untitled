package work.Stack;
import work.Stack.Brace;

public class StackBrace
{
    private Brace[] stack;
    private int tos;

    public StackBrace(int size)
    {
        this.stack = new  Brace[size];
        this.tos = -1;
    }

    public void push(Brace num)
    {
        if(tos < stack.length - 1)
        {
            stack[++tos]= num;
        }
        else
        {
            System.out.println("Stack is full");
        }
    }

    public Brace pop()
    {
        if(tos >= 0)
        {
            return stack[tos--];
        }else
        {
            return null;
        }
    }

    public int length()
    {
        return tos;
    }
}