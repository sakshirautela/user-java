public class a4 {
    static void main() {
        minPartitionScore(new int[]{}, 3);
    }

    public static long minPartitionScore(int[] nums, int k) {
        return minPartitionScoreKcuts(nums, 0, k, nums.length, 0, 0);
    }

    private static long minPartitionScoreKcuts(int[] nums, int i, int k, int n, int sum, int total) {
        if (i == n) {
            if (k == 0) {
                return total + ((sum + nums[i]) * (sum + nums[i] + 1)) / 2;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int res = Integer.MAX_VALUE;
        if (k > 0) {
            res = Math.toIntExact(Math.min(res, minPartitionScoreKcuts(nums, i + 1, k - 1, n, 0, total + ((sum + nums[i]) * (sum + nums[i] + 1)) / 2)));
        }
        return Math.min(res, minPartitionScoreKcuts(nums, i + 1, k, n, sum + nums[i], total));
    }
}
