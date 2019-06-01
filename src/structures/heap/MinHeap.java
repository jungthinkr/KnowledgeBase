package structures.heap;

public class MinHeap extends Heap {
    public MinHeap(int size) {
        super(size);
        heap[0] = Integer.MIN_VALUE;
    }

    private void heapify(int pos) {
        if (isLeaf(pos)) return;

        if (heap[pos] > heap[leftChild(pos)] && heap[leftChild(pos)] < heap[rightChild(pos)]) {
            swap(pos, leftChild(pos));
            heapify(leftChild(pos));
        }

        if (heap[pos] > heap[rightChild(pos)] && heap[leftChild(pos)] >= heap[rightChild(pos)]) {
            swap(pos, rightChild(pos));
            heapify(rightChild(pos));
        }
    }

    public void add(int element) {
        heap[++k] = element;
        int curr = k;
        while (heap[curr] < heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public int poll() {
        int polled = heap[1];
        heap[1] = heap[k--];
        heapify(1);
        return polled;
    }

}
