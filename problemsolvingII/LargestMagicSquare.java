public class LargestMagicSquare {
    static void main() {

    }

    public static int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int s = Math.min(m, n);
        while (s > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + s <= m && j + s <= n) {
                        if (isValid(grid, m, n, i, j, s)) {
                            return s;
                        }
                    }
                }
            }
            s--;
        }

        return 0;
    }

    private static boolean isValid(int[][] grid, int m, int n, int i, int j, int s) {
        int sum = 0;
        int sum2 = 0;
        for (int x = i; x < i + s; x++) {
            sum2 = 0;
            for (int y = j; y < j + s; y++) {
                sum2 += grid[x][y];
            }
            if (x == i) {
                sum = sum2;
            } else if (sum != sum2) {
                return false;
            }
        }
        for (int x = j; x < j + s; x++) {
            sum2 = 0;
            for (int y = i; y < i + s; y++) {
                sum2 += grid[y][x];
            }
            if (sum != sum2) {
                return false;
            }
        }
        sum2 = 0;
        for (int k = 0; k < s; k++) {
            sum2 += grid[i + k][j + k];
        }
        if (sum != sum2) {
            return false;
        }
        sum2 = 0;
        for (int k = 0; k < s; k++) {
            sum2 += grid[i + k][j + s - 1 - k];
        }
        if (sum != sum2) {
            return false;
        }
        return true;

    }
}
