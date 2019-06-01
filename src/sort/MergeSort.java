package sort;


public class MergeSort {
    public static void sort(int[] arr) {
        merge(arr, arr.length);
    }

    private static void merge(int[] arr, int n) {
        if (n == 1) return;

        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        for (int i=0;i<left.length;i++) {
            left[i] = arr[i];
        }

        for (int i=mid;i<n;i++) {
            right[i-mid] = arr[i];
        }

        merge(left, mid);
        merge(right,n-mid);

        int i = 0, j = 0, k = 0;
        while (k < arr.length && i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
