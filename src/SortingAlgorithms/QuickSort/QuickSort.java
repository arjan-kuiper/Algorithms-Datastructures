package SortingAlgorithms.QuickSort;

public final class QuickSort {

    public static int[] sort(int[] input, int min, int max)
    {
        int index = partition(input, min, max);
        if(min < index - 1){
            sort(input, min, index - 1);
        }
        if(index < max){
            sort(input, index, max);
        }
        return input;
    }

    private static int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}
