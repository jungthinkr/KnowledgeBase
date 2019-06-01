import structures.Queue;

public class main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>(10);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
        q.poll();

    }
}
