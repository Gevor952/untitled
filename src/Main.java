import homework.DynamicArray.DynamicArray;
import work.Stack.Stack;


public class Main
{

    public static void main(String[] args)
    {
     DynamicArray arr = new DynamicArray();
     arr.add(0);
     arr.add(1);
     arr.add(2);
     arr.add(3);
     arr.deleteByIndex(2);
     arr.print();
    }
}