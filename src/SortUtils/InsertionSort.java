package SortUtils;

class InsertionSort
{
    static void sort(String arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i)
        {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && Integer.parseInt(arr[j].split("\\.")[0]) > Integer.parseInt(key.split("\\.")[0]))
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
