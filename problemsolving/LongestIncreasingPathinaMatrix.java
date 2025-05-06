public class LongestIncreasingPathinaMatrix {
    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, dp, -1));
            }
        }
        return res;
    }

    private static int dfs(int i, int j, int[][] matrix, int[][] dp, int prev) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= prev)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int cur = matrix[i][j];
        int up = dfs(i - 1, j, matrix, dp, cur);
        int down = dfs(i + 1, j, matrix, dp, cur);
        int left = dfs(i, j - 1, matrix, dp, cur);
        int right = dfs(i, j + 1, matrix, dp, cur);

        dp[i][j] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
        return dp[i][j];
    }
}