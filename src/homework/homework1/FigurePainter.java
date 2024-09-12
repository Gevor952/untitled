package homework.homework1;

public class FigurePainter
{
    public   void fg1(int height)
    {
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void fg2(int height)
    {
        for(int i = height - 1; i >= 0; i-- )
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public  void  fg3(int height)
    {
        int num = height - 1;
        for(int i = height - 1; i >= 0; i--)
        {
            for(int j = 0; j < 5; j++)
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
    }

    public void  fg4(int height)
    {
        int num = 0;
        for(int i = height - 1; i >= 0; i--)
        {
            for(int j = 0; j < 5; j++)
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

    public void fg5(int height)
    {
        for(int i=0; i < height; i++)
        {
            for(int j = 0; j < height; j++)
            {
                if(j >= height - i - 1 )
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

}
