package problemsolvingIII;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class KthSmallestAmountWithSingleDenominationCombination {
    static void main() {
        System.out.println(findKthSmallest(new int[]{3,6,9}, 3));
    }
    public static long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{coins[i],coins[i]});
            set.add(coins[i]);

        }
        int a=k;
        while (k>=0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            pq.add(new int[]{cur[0]+cur[1],cur[1]});
            set.add(cur[0]);
            k--;
        }
        for(int i:set){
            if(a==1){
                return i;
            }
            a--;
        }
        return -1 ;
    }
}
