package com.learn.java.problemsolving;

import java.util.PriorityQueue;

public class MinimumObstacleRemovaltoReachCorner {
    public static int minimumObstacles(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] minObstacle = new int[m][n];
        int[][] dir = { { 0, 1 },
                { 0, -1 },
                { 1, 0 },
                { -1, 0 } };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, 0 });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minObstacle[i][j] = Integer.MAX_VALUE;
            }
        }
        minObstacle[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int obstacle = curr[0], row = curr[1], col = curr[2];
            if (row == m - 1 && col == n - 1) {
                return obstacle;
            }
            for (int[] i : dir) {
                int newRow = row + i[0], newCol = col + i[1];
                if (isValid(m, n, newRow, newCol)) {
                    int newobstacle = obstacle + grid[newRow][newCol];
                    if (newobstacle < minObstacle[newRow][newCol]) {
                        minObstacle[newRow][newCol] = newobstacle;
                        pq.add(new int[] { newobstacle, newRow, newCol });
                    }
                }
            }
        }
        return minObstacle[m - 1][n - 1];
    }

    private static boolean isValid(int m, int n, int newRow, int newCol) {
        if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minimumObstacles(new int[][] { { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 } }));
    }
}