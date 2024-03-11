import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueueJCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq =new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(4);
        pq.add(2);
        System.out.println(pq);
    }
}
