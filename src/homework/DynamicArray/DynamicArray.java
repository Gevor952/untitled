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
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
    public int getByIndex(int index)
    {
        if( index >= 0 && index < size)
        {
            return array[index];
        }
        return -1;
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void deleteByIndex(int index)
    {
        int[] newArray = new int[(size - index) + 10];
        System.arraycopy(array, index + 1, newArray, 0, size );
        System.arraycopy(newArray, 0, array, index , size--);
    }

    public void set(int index, int value)
    {
        if(index >= 0 && index < size)
        {
            array[index] = value;
        }
        else
        {
            System.out.println("index out of bounds");
        }
    }

    public void add(int index, int value)
    {
        if(size == array.length - 2)
        {
            extend();
        }
        if(index >= 0 && index < size)
        {
            int[] newArray = new int[(size - index) + 10];
            System.arraycopy(array, index , newArray, 0, size );
            System.arraycopy(newArray, 0, array, index + 1 , size++);
            array[index] = value;
        }
    }

}
