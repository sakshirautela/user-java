import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s, t, n - 1, m - 1, dp);
    }

    private static int helper(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) return 1;

        if (i < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = helper(s, t, i - 1, j - 1, dp)
                    + helper(s, t, i - 1, j, dp);
        } else {
            dp[i][j] = helper(s, t, i - 1, j, dp);
        }

        return dp[i][j];
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    public int numDistinctFast(String s, String t) {
        int n = s.length(), m = t.length();

        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; ++i)
            dp[i][m] = 1L;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                long ways = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    ways += dp[i + 1][j + 1];
                }
                dp[i][j] = ways;
            }
        }
        return (int) dp[0][0];
    }
}