public class NumberofIncreasingPathsinaGrid {
    public static void main(String[] args) {
        System.out.println(countPaths(new int[][]{{1,1},{3,4}}));
    }
    static int mod=1000000007;
    public static  int countPaths(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res=(res+dfs(i, j, matrix, dp, -1))%mod;
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

        dp[i][j] =( 1 + up+down+left+ right)%mod;
        return dp[i][j];
    }
    final int MODULO =1000000007;

    public int countPaths2(int[][] grid) {
        int count = 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                count = (count + dfs(grid, dp, row, col)) % MODULO;
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int[][] dp, int y, int x) {
        if (dp[y][x] != 0)
            return dp[y][x];

        int paths = 1;
        int current = grid[y][x];

        if (y + 1 < grid.length && current < grid[y + 1][x])
            paths = (paths + dfs(grid, dp, y + 1, x)) % MODULO;

        if (y - 1 >= 0 && current < grid[y - 1][x])
            paths = (paths + dfs(grid, dp, y - 1, x)) % MODULO;

        if (x + 1 < grid[y].length && current < grid[y][x + 1])
            paths = (paths + dfs(grid, dp, y, x + 1)) % MODULO;

        if (x - 1 >= 0 && current < grid[y][x - 1])
            paths = (paths + dfs(grid, dp, y, x - 1)) % MODULO;

        dp[y][x] = paths;

        return paths;
    }
}