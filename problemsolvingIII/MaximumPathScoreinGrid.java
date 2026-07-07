package problemsolvingIII;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPathScoreinGrid {
    static void main() {
        System.out.println();
    }

    public int maxPathScoreBetter(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] pre = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(pre[i], Integer.MIN_VALUE / 2);
        }
        Arrays.fill(pre[n - 1], 0);
        for (int i = m - 1; i >= 0; i--) {
            int[][] dp = new int[n + 1][k + 1];
            Arrays.fill(dp[n], Integer.MIN_VALUE / 2);
            for (int j = n - 1; j >= 0; j--) {
                int c = grid[i][j] > 0 ? 1 : 0;
                for (int x = 0; x <= k; x++) {
                    dp[j][x] = Integer.MIN_VALUE / 2;
                    if (x < c) {
                        continue;
                    }
                    dp[j][x] = grid[i][j] + Math.max(pre[j][x - c], dp[j + 1][x - c]);
                }
            }
            pre = dp;
        }
        return pre[0][k] < 0 ? -1 : pre[0][k];
    }

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int z = 0; z <= k; z++) {
                    dp[i][j][z] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int z = 0; z <= k; z++) {
                    if (dp[i][j][z] != Integer.MIN_VALUE) {
                        if (i + 1 < n) {
                            int val = grid[i][j];
                            int cost = (val != 0) ? 1 : 0;
                            if (cost + z <= k) {
                                dp[i + 1][j][z + cost] = Math.max(dp[i][j][z] + val, dp[i + 1][j][z + cost]);
                            }
                        }
                        if (j + 1 < m) {
                            int val = grid[i][j + 1];
                            int cost = (val != 0) ? 1 : 0;
                            if (cost + z <= k) {
                                dp[i][j + 1][z + cost] = Math.max(dp[i][j][z] + val, dp[i][j + 1][z + cost]);
                            }
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, dp[n - 1][m - 1][k]);
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public int maxPathScoreTLE(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<int[]> paths = new ArrayList<>();
        maxPathScoreUtil(0, 0, n, m, paths, k, grid, 0, 0);
        int maxScore = Integer.MIN_VALUE;
        for (int[] row : paths) {
            if (row[1] <= k) {
                maxScore = Math.max(maxScore, row[0]);
            }
        }
        return maxScore;
    }

    private void maxPathScoreUtil(int i, int j, int n, int m, ArrayList<int[]> paths, int k, int[][] grid, int score, int cost) {
        if (i == n - 1 && j == m - 1) {
            paths.add(new int[]{score, cost});
        }
        if (i >= n || j >= m) {
            return;
        }
        if (grid[i][j] != 0) {
            maxPathScoreUtil(i, j + 1, n, m, paths, k, grid, score + grid[i][j], cost + 1);
            maxPathScoreUtil(i + 1, j, n, m, paths, k, grid, score + grid[i][j], cost + 1);
        } else {
            maxPathScoreUtil(i + 1, j, n, m, paths, k, grid, score, cost);
            maxPathScoreUtil(i, j + 1, n, m, paths, k, grid, score, cost);

        }
    }


}