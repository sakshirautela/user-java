public class MaximumNonNegativeProductinaMatrix {
    static void main() {
        System.out.println(maxProductPath(new int[][]{{1, -2, 1}, {1, -2, 1}, {3, -4, 1}}));
    }

    public static int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] max = new long[n][m];
        long[][] min = new long[n][m];
        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            max[i][0] = (max[i - 1][0] * grid[i][0]) % mod;
            min[i][0] = max[i][0];
        }
        for (int i = 1; i < m; i++) {
            max[0][i] = (max[0][i - 1] * grid[0][i]) % mod;
            min[0][i] = max[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] >= 0) {
                    max[i][j] = Math.max(max[i][j - 1], max[i - 1][j] )* grid[i][j];
                    min[i][j] = Math.min(min[i][j - 1], min[i - 1][j]) * grid[i][j];
                } else {
                    max[i][j] = Math.min(min[i][j - 1], min[i - 1][j]) * grid[i][j];
                    min[i][j] = Math.max(max[i][j - 1], max[i - 1][j]) * grid[i][j];
                }

            }
        }
        if (max[n - 1][m - 1] < 0) {
            return -1;
        }
        return Math.toIntExact((max[n - 1][m - 1]) % mod);
    }

    static int mod = (int) 1000000007;

    //    private static int maxProductPathUtil(int[][] grid, int i, int j, int n, int m, int prod) {
//        if (i >= n || j >= m) return Integer.MIN_VALUE;
//        if (i == n - 1 && j == m - 1) return (prod * (grid[i][j])%mod) % mod;
//        prod = (prod*grid[i][j])%mod;
//        int a = maxProductPathUtil(grid, i + 1, j, n, m, prod);
//        int b = maxProductPathUtil(grid, i, j + 1, n, m, prod);
//        return Math.max(a, b);
//    }
//    class Solution {
//        int m = 0;
//        int n = 0;
//        static final int MOD = 1000000007;
//        long product = -1;
//
//        private void solve(int[][] grid, int i, int j, long curr) {
//            if (i < 0 || i >= m || j < 0 || j >= n) {
//                return;
//            }
//            if (i == m - 1 && j == n - 1) {
//                product = Math.max(product, curr * grid[i][j]);
//                return;
//            }
//            // Note: pruning to remove TLE. Any exploration after a 0 is found is not worth
//            // as the product will be 0.
//            if (grid[i][j] == 0) {
//                product = Math.max(product, 0);
//                return;
//            }
//            curr = curr * grid[i][j];
//            solve(grid, i + 1, j, curr);
//            solve(grid, i, j + 1, curr);
//        }
//
//        public int maxProductPath(int[][] grid) {
//            m = grid.length;
//            n = grid[0].length;
//            int curr = 1;
//            solve(grid, 0, 0, curr);
//            return product < 0 ? -1 : (int) (product % MOD);
//        }
//    }
    static void printdp(long[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
