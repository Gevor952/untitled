package homework.DynamicArray;

public class DynamicArray {

    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value)
    {
        if(size == array.length - 1)
        {
            extend();
        }
        array[size++] = value;
    }

    //1․ ստեղծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ
    //2․ քցել հին մասիվի էլեմենտները նորի մեջ
    //3․ հին մասիվի հղումը կապենք նոր մասիվի հղման հետ։
    private void extend()
    {
        int[] newarray = new int[array.length * 2];
        for(int i = 0; i < size; i++)
        {
            newarray[i] = array[i];
        }
        array = newarray;
    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
    public int getByIndex(int index)
    {
        if( index >= 0 && index < array.length)
        {
            return array[index];
        }
        return -1;
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print()
    {
        for(int i : array)
        {
            System.out.print(i + " ");
        }
    }

}
