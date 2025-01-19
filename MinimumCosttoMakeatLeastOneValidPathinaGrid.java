import java.util.Arrays;
import java.util.LinkedList;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinimumCosttoMakeatLeastOneValidPathinaGrid {
    public static void main(String[] args) {
        System.out.println(minCost(new int[][] { {} }));
    }

    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int minCost[][] = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i[] : minCost) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        minCost[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int cost = curr[0], row = curr[1], col = curr[2];
            for (int i = 0; i < 4; i++) {
                int newRow = row + dir[i][0];
                int newCol = col + dir[i][1];
                if (newRow >= 0 && newRow < n && newCol < m && newCol >= 0) {
                    int newCost = cost + ((i != grid[row][col] - 1) ? 1 : 0);
                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        pq.add(new int[] { newCost, newRow, newCol });
                    }
                }
            }
        }
        return minCost[n - 1][m - 1];
    }

    public int minCost2(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        int cost = 0;
        runAll(grid, 0, 0);
        // System.out.println(dq.size());
        while (!dq.isEmpty()) {
            for (int round = dq.size(); round > 0; round--) {
                int[] cur = dq.pollFirst();
                int r = cur[0], c = cur[1];
                if (r == rows - 1 && c == cols - 1)
                    return cost;
                runAll(grid, r, c);
                for (int k = 0; k < 4; k++) {
                    runAll(grid, r + dr[k], c + dc[k]);
                }
            }
            cost++;
        }
        return -1;
    }

    Deque<int[]> dq = new LinkedList<>();
    int[] dr = new int[] { 0, 0, 1, -1 }, dc = new int[] { 1, -1, 0, 0 };
    boolean[][] visited;
    int rows, cols;

    private void runAll(int[][] grid, int r, int c) {
        while (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
            visited[r][c] = true;
            int dir = grid[r][c] - 1;
            dq.addLast(new int[] { r, c });
            r += dr[dir];
            c += dc[dir];
        }
    }
}
