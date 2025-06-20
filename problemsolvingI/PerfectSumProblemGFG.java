
import java.util.Arrays;

public class PerfectSumProblemGFG {
    public static void main(String[] args) {
        System.out.println(perfectSum(new int[] {}, 3));
    }

    // Function to calculate the number of subsets with a given sum
    public static int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }
        return perfectSumHelper(0, n, dp, 0, target, nums);
    }

    private static int perfectSumHelper(int i, int n, int[][] dp, int sum, int target, int[] nums) {
        if (i == n) {
            return ((sum == target) ? 1 : 0);
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int exclude = perfectSumHelper(i + 1, n, dp, sum, target, nums);

        // include
        int include = 0;
        if (sum + nums[i] <= target) {
            include = perfectSumHelper(i + 1, n, dp, sum + nums[i], target, nums);
        }
        return dp[i][sum] = include + exclude;
    }

    public static int perfectSumDP(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i-1][j-1];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

}
