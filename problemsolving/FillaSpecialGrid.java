public class FillaSpecialGrid {
    public static int[][] specialGrid(int N) {
        // Base case: 1x1 grid
        if (N == 0) {
            return new int[][]{{0}};
        }

        // Build the (2^(N-1) x 2^(N-1)) subgrid
        int[][] sub = specialGrid(N - 1);
        int n = 1 << (N - 1);         // M = 2^(N-1)
        int size = n << 1;            // size = 2^N
        int quadrantSize = n * n;     // number of elements in each quadrant

        int[][] res = new int[size][size];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int base = sub[i][j];
                // Top‑right quadrant (offset 0)
                res[i][j + n]     = base + 0 * quadrantSize;
                // Bottom‑right quadrant (offset 1)
                res[i + n][j + n] = base + 1 * quadrantSize;
                // Bottom‑left quadrant (offset 2)
                res[i + n][j]     = base + 2 * quadrantSize;
                // Top‑left quadrant (offset 3)
                res[i][j]         = base + 3 * quadrantSize;
            }
        }

        return res;
    }

    // Helper to print the grid (for testing)
    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 2;
        int[][] result = specialGrid(N);
        printGrid(result);
    }
}
/*You are given a non-negative integer n representing a 2n x 2n grid. You must fill the grid with integers from 0 to 22n - 1 to make it special. A grid is special if it satisfies all the following conditions:

All numbers in the top-right quadrant are smaller than those in the bottom-right quadrant.
All numbers in the bottom-right quadrant are smaller than those in the bottom-left quadrant.
All numbers in the bottom-left quadrant are smaller than those in the top-left quadrant.
Each of its quadrants is also a special grid.
Return the special 2n x 2n grid.

Note: Any 1x1 grid is special. */