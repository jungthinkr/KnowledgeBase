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

    protected int leftChild(int pos) {
        return 2 * pos;
    }

    protected int rightChild(int pos) {
        return 2 * pos + 1;
    }

    protected boolean isLeaf(int pos) {
        return pos >= k / 2 && pos <= k;
    }

    protected void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
