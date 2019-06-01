package sort;

import structures.heap.MinHeap;

public class HeapSort {
    public static void sort(int[] arr) {
        MinHeap minHeap =  new MinHeap(arr.length);
        for (Integer num : arr) minHeap.add(num);
        int k = 0;
        while (!minHeap.isEmpty()) {
            arr[k++] = minHeap.poll();
        }
    }
}
