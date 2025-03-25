import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        System.out.println(minCoins(new int[] {25,10,5}, 30));
    }

    public static int minCoins(int coins[], int sum) {
        // code here
        int n = coins.length;
        long dp[][] = new long[n + 1][sum + 1];
        for (long[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return (int) minCoinshelper(coins, sum, 0, dp, n);
    }

    private static long minCoinshelper(int[] coins, int sum, int idx, long[][] dp, int n) {
        if (idx >= n) {
            return Integer.MAX_VALUE;
        }
        if (sum == 0) {
            return 0;
        }
        if (dp[idx][sum] != Integer.MAX_VALUE) {
            return dp[sum][idx];
        }
        if (sum - coins[idx] >= 0) {
            long take = 1 + minCoinshelper(coins, sum - coins[idx], idx + 1, dp, n);
            long notake = minCoinshelper(coins, sum, idx + 1, dp, n);
            return dp[idx][sum] = Math.min(take, notake);
        } else {
            return dp[idx][sum] = minCoinshelper(coins, sum, idx + 1, dp, n);

        }
    }
}