import java.util.Scanner;

public class Main
{
    static void tr(int h)
    {
        for(int i=0; i < h; i++)
        {
            for(int j = 0; j < h; j++)
            {
                if(j >= h - i - 1 )
                {
                    System.out.print("* ");
                }
                else
                {
                System.out.print(' ');
                }
            }
            System.out.println();
        }
    }



    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        tr(sc.nextInt());
    }
}