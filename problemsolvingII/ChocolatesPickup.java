import java.util.Arrays;

public class ChocolatesPickup {
    static void main() {
        System.out.println(maxChocolateDP(new int[][]{{4, 1, 2}, {3, 6, 1}, {1, 6, 6}, {3, 1, 2}}));
    }

    static int maxFromNextRow(int r, int c1, int c2, int m, int[][][] dp) {
        int[] dir = {-1, 0, 1};
        int max = 0;
        for (int i = 0; i < dir.length; i++) {
            for (int j = 0; j < dir.length; j++) {
                int d1 = dir[i];
                int d2 = dir[j];

                // checking if next cell doesn't lie outside the
                // grid
                if (c1 + d1 >= 0 && c1 + d1 < m && c2 + d2 >= 0
                        && c2 + d2 < m) {
                    max = Math.max(max,
                            dp[r + 1][c1 + d1][c2 + d2]);
                }
            }
        }

        return max;
    }

    static int maxChocolateDP(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        // the maximum chocolates to be picked
        // if the robot starts in the last row
        // is the number of chocolates in the cell
        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = 0; c2 < m; c2++) {
                dp[n - 1][c1][c2]
                        = (grid[n - 1][c1])
                        + ((c1 != c2) ? grid[n - 1][c2] : 0);
            }
        }

        for (int r = n - 2; r >= 0; r--) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    dp[r][c1][c2]
                            = (grid[r][c1])
                            + ((c1 != c2) ? grid[r][c2] : 0);

                    // getting the max number of chocolates
                    // that can be picked from next row
                    int max
                            = maxFromNextRow(r, c1, c2, m, dp);
                    dp[r][c1][c2] += max;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    System.out.print(dp[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return dp[0][0][m - 1];
    }

    public static int maxChocolate(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][][] dp = new int[n][m][m];
        for (int[][] d : dp) {
            for (int[] a : d) {
                Arrays.fill(a, -1);
            }
        }
        return dfsMaxChoclate(grid, visited, 0, 0, m - 1, n, m, dp);
    }

    private static int dfsMaxChoclate(int[][] grid, boolean[][] visited, int i, int j1, int j2, int n, int m, int[][][] dp) {
        if (i > n || j1 >= m || j2 >= m || j1 < 0 || j2 < 0) return Integer.MIN_VALUE;
        if (i == n) {
            return 0;
        }
        int max = 0;
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int[] dir = {1, 0, -1};
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                max = Math.max(max, dfsMaxChoclate(grid, visited, i + 1, j1 + dir[k], j2 + dir[l], n, m, dp));
            }
        }
        max += grid[i][j1];
        if (j1 != j2) {
            max += grid[i][j2];
        }
        return dp[i][j1][j2] = max;
    }

}