import java.util.Arrays;

public class MinimumCosttoCutaStick {
    static void main() {
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));
    }

    public static int minCostdp(int n, int[] cuts) {
        int len = cuts.length;
        int[][] dp = new int[len + 2][len + 2];
        int[] optimize = new int[len + 2];
        System.arraycopy(cuts, 0, optimize, 1, len);
        optimize[len + 1] = n;
        Arrays.sort(optimize);
        for (int i = len; i >= 1; i--) {
            for (int j = i; j <= len; ++j) {
                int mix = Integer.MAX_VALUE;
                for (int k = i; k <= j; ++k) {
                    int cost = optimize[j + 1] - optimize[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    mix = Math.min(mix, cost);
                }
                dp[i][j] = mix;
            }
        }
        return dp[1][len];
    }

    public static int minCostFast(int n, int[] cuts) {
        int len = cuts.length;
        int[][] dp = new int[len + 2][len + 2];
        int[] optimize = new int[len + 2];
        System.arraycopy(cuts, 0, optimize, 1, len);
        for (int r = 0; r < len + 2; ++r) {
            Arrays.fill(dp[r], -1);
        }
        optimize[len + 1] = n;
        Arrays.sort(optimize);
        return minCostFastHelper(0, len + 1, dp, optimize);
    }

    private static int minCostFastHelper(int i, int j, int[][] dp, int[] optimize) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (j - i == 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = minCostFastHelper(i, k, dp, optimize) + minCostFastHelper(k, j, dp, optimize) + optimize[j] - optimize[i];
            res = Math.min(cost, res);
        }
        return dp[i][j] = res;
    }


    public static int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[][] dp = new int[n + 1][n + 1];
        return dfs(0, n, cuts, dp);
    }

    public static int dfs(int i, int j, int[] cuts, int[][] dp) {
        if (j - i <= 1) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int cut : cuts) {
            if (j > cut && i < cut) {
                int a = dfs(i, cut, cuts, dp);
                int b = dfs(cut, j, cuts, dp);
                res = Math.min(res, j - i + a + b);
            }

        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return dp[i][j] = res;
    }
}