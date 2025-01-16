public class ShortestSubarraywithSumatLeastK {
    public static int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int[] sum=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                sum[0]=nums[0];
            }else{
                sum[i]=sum[i-1]+nums[i];
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(sum[j]-sum[i]>=k){
                    res=Math.min(res,j-i);
                }
            }
        }
        return (res!=Integer.MAX_VALUE)?res:-1;
    }

    public static void main(String args[]) {
        System.out.print(shortestSubarray(new int[] {48,99,37,4,-31}, 3));
    }
}
class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Initialize result to the maximum possible integer value
        int shortestSubarrayLength = Integer.MAX_VALUE;

        long cumulativeSum = 0;

        // Min-heap to store cumulative sum and its corresponding index
        PriorityQueue<Pair<Long, Integer>> prefixSumHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getKey(), b.getKey())
        );

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update cumulative sum
            cumulativeSum += nums[i];

            // If cumulative sum is already >= k, update shortest length
            if (cumulativeSum >= k) {
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i + 1
                );
            }

            // Remove subarrays from heap that can form a valid subarray
            while (
                !prefixSumHeap.isEmpty() &&
                cumulativeSum - prefixSumHeap.peek().getKey() >= k
            ) {
                // Update shortest subarray length
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i - prefixSumHeap.poll().getValue()
                );
            }

            // Add current cumulative sum and index to heap
            prefixSumHeap.offer(new Pair<>(cumulativeSum, i));
        }

        // Return -1 if no valid subarray found
        return shortestSubarrayLength == Integer.MAX_VALUE
            ? -1
            : shortestSubarrayLength;
    }
}