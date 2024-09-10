package homework.homework1.homework1.homework1;

public class FigurePainter
{
    public   void fg1(int hight)
    {
        for(int i = 0; i < hight; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void fg2(int hight)
    {
        for(int i = hight - 1; i >= 0; i-- )
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public  void  fg3(int hight)
    {
        int num = hight - 1;
        for(int i = hight - 1; i >= 0; i--)
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

    public void  fg4(int hight)
    {
        int num = 0;
        for(int i = hight - 1; i >= 0; i--)
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

    public void fg5(int hight)
    {
        for(int i=0; i < hight; i++)
        {
            for(int j = 0; j < hight; j++)
            {
                if(j >= hight - i - 1 )
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
