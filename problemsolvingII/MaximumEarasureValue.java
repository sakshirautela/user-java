import java.util.HashMap;
import java.util.HashSet;

public class MaximumEarasureValue {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] += (i == 0) ? nums[i] : pre[i - 1] + nums[i];
        }
        int flag = -1;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(nums[i])) {
                if (flag < hm.get(nums[i])) {
                    flag = hm.get(nums[i]);

                }
            }
            if (flag == -1) {
                result = pre[i];
            } else {
                result = Math.max(pre[i] - pre[flag], result);

            }
            hm.put(nums[i], i);
        }
        return result;
    }
        public int maximumUniqueSubarrayFast(int[] nums) {

            int[] lastIndex = new int[10001];
            for (int i = 0; i < lastIndex.length; i++) {
                lastIndex[i] = -1;
            }
            int l = -1, sum = 0;
            int[] prefixSum = new int[nums.length+1];

            for (int r = 0; r < nums.length; r++) {
                prefixSum[r+1] = nums[r] + prefixSum[r];
                if (lastIndex[nums[r]] >= 0) {
                    l = Math.max(l, lastIndex[nums[r]]);
                }
                sum = Math.max(sum, prefixSum[r+1] - prefixSum[l+1]);
                lastIndex[nums[r]] = r;
            }

            return sum;

        }
}
