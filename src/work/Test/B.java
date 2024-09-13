package work.Test;

public class B extends A
{
    private int x;

    public B(int a, int b, int x)
    {
        super(a, b);
        this.x = x;
    }

    public void pr()
    {
        System.out.println(x);
    }
}
