package SortUtils;

import java.util.Arrays;

class RadixSort
{
    private static String getMax(String arr[], int n)
    {
        String mx = arr[0];
        for (int i = 1; i < n; i++)
            if (Integer.parseInt(arr[i].split("\\.")[0]) > Integer.parseInt(mx.split("\\.")[0]))
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private static void countSort(String arr[], int n, int exp)
    {
        String output[] = new String[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(Integer.parseInt(arr[i].split("\\.")[0]) / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[(Integer.parseInt(arr[i].split("\\.")[0]) / exp) % 10] - 1] = arr[i];
            count[(Integer.parseInt(arr[i].split("\\.")[0]) / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix SortUtils.Sort
    static void sort(String arr[], int n)
    {
        // Find the maximum number to know number of digits
        String m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; Integer.parseInt(m.split("\\.")[0]) / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
