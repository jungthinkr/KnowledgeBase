package sort;

// LAME
public class CountingSort {
    public static void sort(int[] arr) {
        int[] values = new int[Integer.MAX_VALUE];
        int k = 0;

        for (Integer num : arr) values[num]++;
        for (int i=0;i<values.length;i++) {
            if (values[i] > 0) {
                for (int j=0;j<values[i];j++) {
                    arr[k++] = i;
                }
            }
        }
    }
}
