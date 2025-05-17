import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
    }

    static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < m && nr >= 0 && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            q.add(new int[] { nr, nc });
                            rotten = true;
                            total--;
                            grid[nr][nc] = 2;
                        }
                    }
                }
            }
            if (rotten) {
                time++;
            }
        }
        return (total == 0) ? time : -1;
    }

    @SuppressWarnings("unused")
    private static int getRotten(int[][] grid, int i, int j, int m, int n, int rotten, int time, int total) {
        if (i == m || i < 0 || j < 0 || j == n || grid[i][j] == 0) {
            if (rotten != total) {
                return Integer.MAX_VALUE;
            } else {
                return time;
            }
        }
        if (rotten == total) {
            return time;
        }
        if (grid[i][j] == 1) {
            rotten++;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        int a = getRotten(grid, i, j - 1, m, n, rotten, time + 1, total);
        a = Math.min(a, getRotten(grid, i, j + 1, m, n, rotten, time + 1, total));
        a = Math.min(a, getRotten(grid, i + 1, j, m, n, rotten, time + 1, total));
        a = Math.min(a, getRotten(grid, i - 1, j, m, n, rotten, time + 1, total));
        grid[i][j] = val;
        return a;
    }
    /*
        0 -> empty
        1 -> fresh
        2 -> rotten
    */

    int m;
    int n;

    public int orangesRotting2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] result = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    start(grid, r - 1, c, 0, result);
                    start(grid, r + 1, c, 0, result);
                    start(grid, r, c - 1, 0, result);
                    start(grid, r, c + 1, 0, result);
                }
            }
        }

        System.out.println(Arrays.deepToString(result));
        int max = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                max = Math.max(max, result[r][c]);
                if (grid[r][c] == 1 && result[r][c] == 0) {
                    return -1;
                }
            }
        }

        return max;
    }

    void start(int[][] grid, int r, int c, int time, int result[][]) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || grid[r][c] == 2) {
            return;
        }

        time++;
        if (result[r][c] != 0 && result[r][c] < time) {
            return;
        }

        result[r][c] = time;

        start(grid, r - 1, c, time, result);
        start(grid, r + 1, c, time, result);
        start(grid, r, c - 1, time, result);
        start(grid, r, c + 1, time, result);
    }
}