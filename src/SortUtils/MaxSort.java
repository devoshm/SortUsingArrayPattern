package SortUtils;

class MaxSort
{
    static void sort(int arr[], int arrLength)
    {
        if (arrLength == 1)
        {
            return;
        }

        int maxIndex = 0, i;
        int swap;
        for (i = 0; i < arrLength; i++)
        {
            if (arr[i] > arr[maxIndex])
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
