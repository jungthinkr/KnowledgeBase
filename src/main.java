import sort.BubbleSort;
import sort.HeapSort;

import java.util.Arrays;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        // Test sorts
        int[] arr = new int[100];
        Random random = new Random();
        for (int i=0;i<arr.length;i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        HeapSort.sort(arr);
    }

    public static boolean isSorted(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            if (arr[i-1] > arr[i]) return false;
        }
        return true;
    }
}
