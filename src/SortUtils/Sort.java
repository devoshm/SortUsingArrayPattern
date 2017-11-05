package SortUtils;

public class Sort
{
    static int counter;

    public static void main(String args[])
    {
        String arr1[] = {"12", "11", "13", "5", "6", "7", "24", "3"};
        String arr2[] = {"28", "11", "9", "10", "18"};
        String arr3[] = new String[12];

//        counter = 0;
//        SortUtils.MaxSort.sort(arr1, arr1.length);
//        printarr(arr1);
//        System.out.println(counter);
//
//        counter = 0;
//        SortUtils.MaxSort.sort(arr2, arr2.length);
//        printarr(arr2);
//        System.out.println(counter);

        counter = 0;
        arr3 = new String[]{"8", "9.a", "28", "11.a", "10", "11.b", "23", "9.b", "21", "7", "11.c", "4"};
        InsertionSort.sort(arr3);
        printarr("SortUtils.InsertionSort", arr3);
        System.out.println(counter);

        counter = 0;
        arr3 = new String[]{"8", "9.a", "28", "11.a", "10", "11.b", "23", "9.b", "21", "7", "11.c", "4"};
        MaxSort.sort(arr3, arr3.length);
        printarr("SortUtils.MaxSort", arr3);
        System.out.println(counter);

        counter = 0;
        arr3 = new String[]{"8", "9.a", "28", "11.a", "10", "11.b", "23", "9.b", "21", "7", "11.c", "4"};
        QuickSort.sort(arr3, 0, arr3.length - 1);
        printarr("SortUtils.QuickSort", arr3);
        System.out.println(counter);

        counter = 0;
        arr3 = new String[]{"8", "9.a", "28", "11.a", "10", "11.b", "23", "9.b", "21", "7", "11.c", "4"};
        HeapSort.sort(arr3);
        printarr("SortUtils.HeapSort", arr3);
        System.out.println(counter);

        counter = 0;
        arr3 = new String[]{"8", "9.a", "28", "11.a", "10", "11.b", "23", "9.b", "21", "7", "11.c", "4"};
        MergeSort.sort(arr3, 0, arr3.length-1);
        printarr("SortUtils.MergeSort", arr3);
        System.out.println(counter);

        counter = 0;
        arr3 = new String[]{"8", "9.a", "28", "11.a", "10", "11.b", "23", "9.b", "21", "7", "11.c", "4"};
        ShellSort.sort(arr3);
        printarr("SortUtils.ShellSort", arr3);
        System.out.println(counter);

        counter = 0;
        arr3 = new String[]{"8", "9.a", "28", "11.a", "10", "11.b", "23", "9.b", "21", "7", "11.c", "4"};
        RadixSort.sort(arr3, arr3.length);
        printarr("SortUtils.RadixSort", arr3);
        System.out.println(counter);
    }

    private static void printarr(String sortName, String arr[])
    {
        System.out.println(sortName);
        for (String anArr : arr)
        {
            System.out.print(anArr + " ");
        }
        System.out.println();
    }
}
