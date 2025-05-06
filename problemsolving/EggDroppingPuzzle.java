public class EggDroppingPuzzle {
    public static void main(String[] args) {
        System.out.println(eggDrop(2, 36));
    }

    public static int eggDrop(int n, int k) {
        int res = 0;
        int[] dp=new int[n+1];
        while (dp[n]<k) {
            res++;
            for (int i = n; i >0; i--) {
                dp[i]+=dp[i-1]+1;
            }
        }
        return res;
    }

    public static int eggDropDp(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int j = 1; j <= k; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }
        return dp[n][k];
    }

    public static int eggDropMy(int n, int k) {
        int dp[][] = new int[k + 1 + 1][n + 1];
        return getDrop(k, n, dp);
    }

    private static int getDrop(int n, int k, int[][] dp) {
        if (n <= 1) {
            return n;
        }
        if (k == 1) {
            return n;
        }
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            // if breaks
            int breaks = getDrop(i - 1, k - 1, dp);
            // if not breaks
            int notbreaks = getDrop(n - i, k, dp);
            res = Math.min(res, 1 + Math.max(breaks, notbreaks));

        }
        return dp[n][k] = res;
    }

    public static int eggDropMath(int n, int k) {
        return (int) Math.ceil((Math.sqrt(1 + 8.0 * k) - 1) / (2 * 1.0));

    }

}