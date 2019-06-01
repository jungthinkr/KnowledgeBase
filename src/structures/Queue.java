package structures;

public class Queue<T> {
    private Object[] arr;
    private int k;

    public Queue(int size) {
        arr = new Object[size];
    }

    public void add(T element) {
        if (k >= arr.length) return;
        arr[k++] = element;
    }

    public T poll() throws IndexOutOfBoundsException {
        if (k == 0) throw new IndexOutOfBoundsException();

        // reference first element of array
        T element = (T) arr[0];

        // shift elements over to the left by 1
        k--;
        for (int i=1;i<arr.length;i++) {
            arr[i-1] = arr[i];
        }

        return element;
    }

    public boolean isEmpty() {
        return k == 0;
    }
}
