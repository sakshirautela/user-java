
import java.util.PriorityQueue;

public class MinimumTimetoVisitaCellInaGrid {

    public static int minimumTime(int[][] grid) {
        // If both initial moves require more than 1 second, impossible to proceed
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int rows = grid.length, cols = grid[0].length;
        // Possible movements: down, up, right, left
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[rows][cols];

        // Priority queue stores {time, row, col}
        // Ordered by minimum time to reach each cell
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] { grid[0][0], 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];

            // Check if reached target
            if (row == rows - 1 && col == cols - 1) {
                return time;
            }

            // Skip if cell already visited
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            // Try all four directions
            for (int[] d : directions) {
                int nextRow = row + d[0], nextCol = col + d[1];
                if (!isValid(visited, nextRow, nextCol)) {
                    continue;
                }

                // Calculate the wait time needed to move to next cell
                int waitTime = ((grid[nextRow][nextCol] - time) % 2 == 0) ? 1 : 0;
                int nextTime = Math.max(grid[nextRow][nextCol] + waitTime, time + 1);
                pq.add(new int[] { nextTime, nextRow, nextCol });
            }
        }
        return -1;
    }

    private static final int[][] MOVES = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int minimumTime2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] seen = new boolean[rows][cols];

        pq.offer(new int[] { 0, 0, 0 }); // time, row, col
        seen[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int[] dir : MOVES) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols ||
                        seen[newRow][newCol]) {
                    continue;
                }

                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }

                if (newRow == rows - 1 && newCol == cols - 1) {
                    return newTime;
                }

                seen[newRow][newCol] = true;
                pq.offer(new int[] { newTime, newRow, newCol });
            }
        }

        return -1;
    }

    // Checks if given cell coordinates are valid and unvisited
    private static boolean isValid(boolean[][] visited, int row, int col) {
        return (row >= 0 &&
                col >= 0 &&
                row < visited.length &&
                col < visited[0].length &&
                !visited[row][col]);
    }

    public static void main(String arsg[]) {
        System.out.println(minimumTime(new int[][] { {} }));
    }
}
