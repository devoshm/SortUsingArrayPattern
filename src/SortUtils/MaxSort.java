package SortUtils;

class MaxSort
{
    static void sort(String arr[], int arrLength)
    {
        if (arrLength == 1)
        {
            return;
        }

        int maxIndex = 0, i;
        String swap;
        for (i = 0; i < arrLength; i++)
        {
            Sort.counter++;
            if (Integer.parseInt(arr[i].split("\\.")[0]) > Integer.parseInt(arr[maxIndex].split("\\.")[0]))
            {
                maxIndex = i;
            }
        }

        arrLength = arrLength - 1;
        swap = arr[maxIndex];
        arr[maxIndex] = arr[arrLength];
        arr[arrLength] = swap;

        sort(arr, arrLength);
    }
}
