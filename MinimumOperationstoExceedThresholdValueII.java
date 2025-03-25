import java.util.*;
import java.util.stream.Collectors;
public class MinimumOperationstoExceedThresholdValueII {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>(
            Arrays.stream(nums)
                .mapToLong(i -> (long) i)
                .boxed()
                .collect(Collectors.toList())
        );
        int numOperations = 0;

        while (minHeap.peek() < k) {
            long x = minHeap.remove();
            long y = minHeap.remove();
            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));

            numOperations++;
        }
        return numOperations;
    }
}
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            if(num<k) pq.add(num);
        }
        int op = 0;

        while(!pq.isEmpty()){
            int x = pq.poll();
            op++;
            if(pq.isEmpty()) break;
            int y = pq.poll();
            long up = 2l * x + y;
            if(up<k) pq.add((int)up);
        }
        return op;
    }
}