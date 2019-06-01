package structures;

import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] arr;
    private int k;

    public Stack(int size) {
        arr = new Object[size];
    }

    public void push(T element) {
        if (k >= arr.length) return;
        arr[k++] = element;
    }

    public T peek() throws EmptyStackException {
        if (k == 0) throw new EmptyStackException();
        return (T) arr[k-1];
    }

    public T pop() throws EmptyStackException {
        if (k == 0) throw new EmptyStackException();
        return (T) arr[--k];
    }

    public boolean isEmpty() {
        return k == 0;
    }
}
