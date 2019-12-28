package sort;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr) {
       sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) return;

        int index = partition(arr, start, end);
        System.out.println(Arrays.toString(arr));

        sort(arr, start, index-1);
        sort(arr, index+1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, start++, j);
            }
        }
        swap(arr, start, end);
        return start;
    }

    private static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
