package problemsolvingIII;

import java.util.PriorityQueue;

public class MaximumTotalSubarrayValueII {
    static void main() {
        System.out.println(maxTotalValue(new int[]{1, 3, 2}, 2));
    }

    public static long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int min = Integer.MAX_VALUE;
        int idx_min=0;
        for (int i=0;i<n;i++) {
            pq.add(i);
            if(min>nums[i]){
                min=nums[i];
                idx_min=i;
            }
        }
        long total = -((long) k *min);
        int left_range=0;
        int right_range=n-1;
        System.out.println(pq);
        while (!pq.isEmpty() && k > 0) {
            int idx_max = pq.poll();
            if(idx_max>idx_min){
                total+=((long) (idx_min - left_range) *(right_range-idx_max)*nums[idx_max]);
                left_range=idx_min+1;
                right_range=idx_max-1;
            }
            k--;
        }
        return total;
    }
}
