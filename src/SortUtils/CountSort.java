package SortUtils;

public class CountSort
{
    static void sort(int arr[])
    {
        int n = arr.length;

        int output[] = new int[n];

        int maxVal = getMax(arr) + 1;
        int count[] = new int[maxVal];
        for (int i = 0; i < maxVal; ++i)
            count[i] = 0;

        for (int anArr : arr) ++count[anArr];

        for (int i = 1; i < maxVal; ++i)
            count[i] += count[i - 1];

        for (int anArr : arr)
        {
            output[count[anArr] - 1] = anArr;
            --count[anArr];
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    private static int getMax(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int val : arr)
        {
            if (val > max)
            {
                max = val;
            }
        }
        return max;
    }
}
