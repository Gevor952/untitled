package homework.Array_Sort;

public class ArraySort
{
    public static void main(String[] args)
    {
        int[] arr = {9, 4, 7, 5, 33, 5, 3, 8, 6};
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = i + 1; j < arr.length; j++ )
            {
                if(arr[i] > arr[j])
                {
                    int num = arr[i];
                    arr[i]= arr[j];
                    arr[j] = num;
                }
            }
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
