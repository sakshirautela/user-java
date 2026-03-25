public class CountSubmatriceswithTopLeftElementandSumLessThanK {
    static void main() {
        System.out.println(countSubmatrices(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20));
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] presum = new int[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                presum[i][j] = grid[i][j];
                if (i > 0) presum[i][j] += presum[i - 1][j];
                if (j > 0) presum[i][j] += presum[i][j - 1];
                if (i > 0 && j > 0) presum[i][j] -= presum[i - 1][j - 1];
                if (presum[i][j] <= k) {
                    result++;
                }
            }
        }
        return result;
    }

    public int countSubmatricesFast(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] cols = new int[m];
        int res = 0;

        for (int i = 0; i < n; i++) {
            int rows = 0;
            for (int j = 0; j < m; j++) {
                cols[j] += grid[i][j];
                rows += cols[j];
                if (rows <= k) {
                    res++;
                }
            }
        }

        return res;
    }
}