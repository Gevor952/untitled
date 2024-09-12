package work.Stack;

public class Stack
{
    private int[] stack;
    private int tos;

    public Stack(int size)
    {
        this.stack = new int[size];
        this.tos = -1;
    }

    public void push(int num)
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

    public int pop()
    {
        if(tos >= 0)
        {
            return stack[tos--];
        }else
        {
            System.out.println("Stack is empty");
            return 0;
        }
    }
}
