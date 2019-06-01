package sort;

public class InsertionSort {
    public static void sort(int arr[]) {
        sort(arr, arr.length);
    }


    /**
        Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position
    */

    private static void sort(int arr[], int n) {
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            for (;j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = key;
        }
    }
}
