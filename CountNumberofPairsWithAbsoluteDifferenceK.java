public class CountNumberofPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {

    }

    public int countKDifference(int[] nums, int k) {
        return helper(nums, k, 0);
    }

    private static int helper(int[] nums, int k, int i) {
        if (i >= nums.length) {
            return 0;
        }
        int count = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[i] - nums[j]) == k) {
                count++;
            }
        }
        return count + helper(nums, k, i + 1);
    }

    public int countKDifference2(int[] nums, int k) {
        int MAX = 100;
        int res = 0;
        int[] count = new int[MAX + 1];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = k + 1; i < count.length; i++) {
            res += count[i] * count[i - k];
        }

        return res;
    }
}