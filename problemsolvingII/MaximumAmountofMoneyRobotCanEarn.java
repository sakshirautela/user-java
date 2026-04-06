import java.util.Arrays;

public class MaximumAmountofMoneyRobotCanEarn {
    static void main() {
        System.out.println(maximumAmountDP(new int[][]{{-7, 12, 12, 13}, {-6, 19, 19, -6}, {9, -2, -10, 16}, {-4, 14, 10, 9}}));
    }

    public static int maximumAmountDP(int[][] coins) {
        int n = coins[0].length;
        int[][] dp = new int[n + 1][3];
        for (int[] rows : coins) {
            for (int i = 1; i <= n; i++) {
                int val = rows[i - 1];
                dp[i][2] = Math.max(Math.max(dp[i - 1][2] + val, dp[i][2] + val), Math.max(dp[i - 1][1], dp[i][1]));
                dp[i][1] = Math.max(Math.max(dp[i - 1][1] + val, dp[i][1] + val), Math.max(dp[i - 1][0], dp[i][0]));
                dp[i][0] = Math.max(dp[i - 1][0]+val, dp[i][0]+val);
            }
        }
        return dp[n][2];
    }

    public static int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        int[][][] dp = new int[n][m][3];
        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return maximumAmountUtill(n, m, 0, 0, coins, 2, dp);
    }


    private static int maximumAmountUtill(int n, int m, int i, int j, int[][] coins, int cell, int[][][] dp) {
        if (i >= n || j >= m) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j][cell] != Integer.MIN_VALUE) {
            return dp[i][j][cell];
        }
        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] < 0 && cell > 0) {
                return 0;
            }
            return coins[i][j];
        }
        int cost = coins[i][j] + Math.max(maximumAmountUtill(n, m, i + 1, j, coins, cell, dp),
                maximumAmountUtill(n, m, i, j + 1, coins, cell, dp));
        int skip = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && cell > 0) {
            skip = Math.max(maximumAmountUtill(n, m, i + 1, j, coins, cell - 1, dp), maximumAmountUtill(n, m, i, j + 1, coins, cell - 1, dp));
        }
        return dp[i][j][cell] = Math.max(skip, cost);
    }
}
