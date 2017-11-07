package SortUtils;

class QuickSort
{
    private static int partition(String arr[], int low, int high)
    {
        int pivot = Integer.parseInt(arr[high].split("\\.")[0]);
        int i = (low - 1);
        for (int j = low; j < high; j++)
        {
            if (Integer.parseInt(arr[j].split("\\.")[0]) <= pivot)
            {
                i++;

                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(String arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
