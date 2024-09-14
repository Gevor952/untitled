package homework.BraceChecker;

import java.util.Scanner;

public class BraceCheckerTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        BraceChecker bc = new BraceChecker(input.nextLine());
        bc.check();
    }
}
