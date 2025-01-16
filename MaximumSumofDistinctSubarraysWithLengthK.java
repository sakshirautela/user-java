import java.util.HashSet;

public class MaximumSumofDistinctSubarraysWithLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        long sum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]);
                sum += nums[i];
                if (i - start + 1 == k) {
                    res = Math.max(res, sum);
                    sum -= nums[start];
                    hs.remove(nums[start]);
                    start++;
                }
            } else {
                while (nums[start] != nums[i]) {
                    hs.remove(nums[start]);
                    sum -= nums[start];
                    start++;
                }
                start++;
            }
        }
        return res;
    }

    public long maximumSubarraySum2(int[] nums, int k) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] counts = new int[maxNum + 1];
        int dupCount = 0;
        long totalSum = 0;
        long curSum = 0;
        for (int i = 0; i < k; i++) {
            if (counts[nums[i]] >= 1) {
                dupCount++;
            }
            counts[nums[i]]++;
            curSum += nums[i];
        }
        if (dupCount == 0) {
            totalSum = curSum;
        }
        for (int i = k; i < nums.length; i++) {
            if (counts[nums[i]] >= 1) {
                dupCount++;
            }
            counts[nums[i]]++;
            curSum += nums[i];
            if (counts[nums[i - k]] > 1) {
                dupCount--;
            }
            counts[nums[i - k]]--;
            curSum -= nums[i - k];
            if (dupCount == 0) {
                totalSum = Math.max(totalSum, curSum);
            }
        }
        return totalSum;
    }

    public static void main(String args[]) {
        System.out.print(maximumSubarraySum(new int[] { 1, 5, 4, 2, 9, 9, 9 }, 3));
    }
}
