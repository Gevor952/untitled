package homework1;

public class FigurePainter
{
    public static void main(String[] args)
    {
        for(byte i = 0; i < 5; i++)
        {
            for(byte j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for(byte i = 4; i >= 0; i-- )
        {
            for(byte j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        byte num = 4;
        for(byte i = 4; i >= 0; i--)
        {
            for(byte j = 0; j < 5; j++)
            {
                if(j >= num)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            num--;
            System.out.println();
        }
        System.out.println();
        System.out.println();
        num = 0;
        for(byte i = 4; i >= 0; i--)
        {
            for(byte j = 0; j < 5; j++)
            {
                if(j >= num)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            num++;
            System.out.println();
        }

    }
}
