import java.util.Arrays;

public class GoldMineProblem {
    public static void main(String[] args) {
        // Example usage
        int[][] mat = {
                { 1, 3, 1, 5 },
                { 2, 2, 4, 1 },
                { 5, 0, 2, 3 },
                { 0, 6, 1, 2 }
        };
        System.out.println(maxGold(mat)); // Output the maximum gold collected
    }

    public static int maxGold(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, getMaxMinedGold(mat, i, 0, n, m, dp));
        }
        return max;
    }

    private static int getMaxMinedGold(int[][] mat, int i, int j, int n, int m, int[][] dp) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        int ans = mat[i][j];
        ans +=Math.max( getMaxMinedGold(mat, i - 1, j + 1, n, m, dp),Math.max( getMaxMinedGold(mat, i, j + 1, n, m, dp),getMaxMinedGold(mat, i + 1, j + 1, n, m, dp)));
        return dp[i][j]=ans;
    }
}