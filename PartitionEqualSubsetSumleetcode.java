public class PartitionEqualSubsetSumleetcode {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[] { 14, 9, 8, 4, 3, 2 }));
    }

    public static boolean canPartitionTLE(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[n][sum / 2];
        return getSum(0, sum / 2, nums, 0, n, dp);
    }

    private static boolean getSum(int sum, int target, int[] nums, int i, int n, boolean[][] dp) {
        if (i == n) {
            return (sum == target);
        }
        if (dp[i][sum]) {
            return true;
        }
        // include
        return getSum(sum, target, nums, i + 1, n, dp) || getSum(sum + nums[i], target, nums, i + 1, n, dp);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum/=2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }

    // private boolean solve(int idx, int k, int[] nums, int[][] dp){
    // if (k == 0)
    // return true;

    // if (idx == 0)
    // return nums[0] == k;

    // if (dp[idx][k] != -1)
    // return dp[idx][k] == 0 ? false : true;

    // boolean notTaken = solve(idx - 1, k, nums, dp);

    // boolean taken = false;

    // if (nums[idx] <= k)
    // taken = solve(idx - 1, k - nums[idx], nums, dp);

    // dp[idx][k] = notTaken || taken ? 1 : 0;
    // return notTaken || taken;
    // }

    Boolean canPartition(Boolean[] memo, int s, int index, int[] nums) {
        if (s == 0)
            return true;

        if (s < 0)
            return false;

        if (index == 0)
            return s == nums[0];

        if (memo[s] != null)
            return memo[s];

        return memo[s] = canPartition(memo, s - nums[index], index - 1, nums) || canPartition(memo, s, index - 1, nums);
    }

    public boolean canPartition2(int[] nums) {

        int s = 0;

        for (int i = 0; i < nums.length; i++)
            s += nums[i];

        if (s % 2 != 0)
            return false;

        int n = nums.length;

        s /= 2;

        Boolean[] memo = new Boolean[s + 1];

        return canPartition(memo, s, n - 1, nums);

        // int sum = 0;
        // int n = nums.length;

        // for(int i : nums){
        // sum += i;
        // }

        // if(sum % 2 == 1){
        // return false;
        // }else{
        // int k = sum / 2;

        // int dp[][] = new int[n][k + 1];

        // for (int row[] : dp)
        // Arrays.fill(row, -1);

        // return solve(n - 1, k, nums, dp);
        // }

    }
}