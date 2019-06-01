package structures.heap;

class Heap {
    protected int[] heap;
    protected int k = 0;

    public Heap(int N) {
        heap = new int[N + 1];
    }

    /**
     * pos of parent
     */
    protected int parent(int pos) {
        return pos / 2;
    }

    /**
     * pos of left child
     */
    protected int leftChild(int pos) {
        return 2 * pos;
    }

    /**
     * pos of right child
     */
    protected int rightChild(int pos) {
        return 2 * pos + 1;
    }

    /**
     * determine if element has no children
     */
    protected boolean isLeaf(int pos) {
        return pos > k / 2 && pos <= k;
    }

    /**
     * swap heap
     */
    protected void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return k == 0;
    }
}
