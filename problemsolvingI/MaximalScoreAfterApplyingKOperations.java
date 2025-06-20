
import java.util.*;

public class MaximalScoreAfterApplyingKOperations {
    public static long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            pq.add(i);
        }
        while (k > 0) {
            int maxElement = pq.poll();
            ans += maxElement;
            pq.add((int) Math.ceil(maxElement / 3.0));
            k--;
        }
        return ans;
    }
        public long maxKelements2(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for(int i : nums){
                pq.add(i);
            }
            long ans = 0;
            while(k-- > 0){
                int n = pq.poll();
                ans += n;
                pq.offer((n + 2)/ 3);
            }
            return ans;
        }

    public static void main(String args[]) {
        System.out.println(maxKelements(new int[] { 1, 3, 5, 67, 33 }, 5));
    }
}
