package sort;

public class QuickSort {
    public static void sort(int[] arr) {
       sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int partition = arr[(start+end)/2];
        int index = partition(arr, start, end, partition);

        sort(arr, start, index-1);
        sort(arr, index, end);
    }

    private static int partition(int[] arr, int start, int end, int partition) {
        while (start <= end) {
            while (arr[start] < partition) start++;
            while (arr[end] > partition) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
