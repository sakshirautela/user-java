
public class TargetSum494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        // Expected output: 5
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysHelper(nums, target, 0, 0);
    }

    private static int findTargetSumWaysHelper(int[] nums, int target, int idx, int currentSum) {
        if (idx == nums.length) {
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        // Two choices:
        // 1. Add current number
        int plus = findTargetSumWaysHelper(nums, target, idx + 1, currentSum + nums[idx]);

        // 2. Subtract current number
        int minus = findTargetSumWaysHelper(nums, target, idx + 1, currentSum - nums[idx]);

        return plus + minus;
    }
}
