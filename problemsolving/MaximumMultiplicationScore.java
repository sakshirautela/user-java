import java.util.Arrays;

public class MaximumMultiplicationScore {
    public static long maxScore(int[] a, int[] b) {
        long[][] dp = new long[5][b.length + 1];
        for (int i = 1; i <= 4; i++) {
            for (int j = i; j <= b.length; j++) {
                long take = dp[i - 1][j - 1] + (long) a[i - 1] * b[j - 1];
                long notTake = dp[i][j - 1];
                if (j - 1 < i) {
                    dp[i][j] = take;
                } else {
                    dp[i][j] = Math.max(take, notTake);
                }
            }
        }

        return dp[4][b.length];
    }

    public long maxScore2(int[] a, int[] b) {
        long ans = Long.MIN_VALUE;
        int b1 = b[0], b2 = b[1], b3 = b[2];
        long mx3 = (long) -1e11;
        long mx2 = (long) -1e11;
        long mx1 = (long) -1e11;
        for (int i = 0; i < b.length; i++) {
            // if (i >= 3)
            ans = Math.max(ans, mx1 + (long) a[3] * b[i]);
            mx1 = Math.max(mx1, mx2 + (long) a[2] * b[i]);
            mx2 = Math.max(mx2, mx3 + (long) a[1] * b[i]);
            mx3 = Math.max(mx3, (long) a[0] * b[i]);
        }
        // System.out.println(mx3 + " " + mx2 + " " + mx1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[] { 1, 2, 3 }, new int[] { 3, 2 })); // Example: Output should be 9
    }
}
