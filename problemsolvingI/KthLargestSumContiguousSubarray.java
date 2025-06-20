import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestSumContiguousSubarray {
    public static void main(String[] args) {
        System.out.println(kthLargest(new int[] {}, 0));
    }

    public static int kthLargest2(int[] arr, int k) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                sums.add(sum);
            }
        }
        Collections.sort(sums, Collections.reverseOrder());
        return sums.get(k - 1);
    }

    public static int kthLargest(int[] arr, int k) {
        // code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                pq.add(sum);
            }
        }
        while (!pq.isEmpty()) {
            if (k == 1) {
                return pq.poll();
            }
            k--;
            pq.poll();
        }
        return -1;
    }
}