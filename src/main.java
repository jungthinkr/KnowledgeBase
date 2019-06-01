import sort.BubbleSort;
import sort.HeapSort;

import java.util.Arrays;
// TODO: fix minheap and maxheap
public class main {
    public static void main(String[] args) {
        // Test sorts
        int[] arr = new int[]{1,5,1,6,7,1,0};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
