package com.learn.java.problemsolving;

public class MaximumNumberofMovesinaGrid {

    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxMoves = 0;

        // Try every cell as a starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxMoves = Math.max(maxMoves, maxMovesHelper(i, j, m, n, grid, 0, -1));
            }
        }
        return maxMoves;
    }

    private static int maxMovesHelper(int i, int j, int m, int n, int[][] grid, int k, int prev) {
        // Base case: out of bounds or the current cell is not greater than the previous cell
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] <= prev) {
            return k;
        }

        // Store the current value
        prev = grid[i][j];

        // Move in all four directions
        int max = k;
        max = Math.max(max, maxMovesHelper(i + 1, j, m, n, grid, k + 1, prev)); // Move down
        max = Math.max(max, maxMovesHelper(i - 1, j, m, n, grid, k + 1, prev)); // Move up
        max = Math.max(max, maxMovesHelper(i, j + 1, m, n, grid, k + 1, prev)); // Move right
        max = Math.max(max, maxMovesHelper(i, j - 1, m, n, grid, k + 1, prev)); // Move left

        return max;
    }

    public static void main(String[] args) {
        // Example test case
        System.out.println(maxMoves(new int[][]{
                {1, 3, 1},
                {6, 5, 4},
                {7, 8, 9}
        }));  // Expected output: 3
    }
}
