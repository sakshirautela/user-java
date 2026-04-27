package problemsolvingIII;

public class DetectCyclesin2DGrid {
    static void main() {
        System.out.println(containsCycle(new char[][]{{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}}));
    }

    public static boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid, grid[i][j], m, n, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private static boolean dfs(int i, int j, int pi, int pj, char[][] grid, char c, int m, int n, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= n || nj >= m || (ni == pi && nj == pj) || grid[ni][nj] != c) {
                continue;
            }
            printVisited(visited);
            System.out.println(" new line");
            if(visited[ni][nj]) {
                System.out.println(pi + " " + pj + " " + i+" "+j + " " +ni +" " + nj);
                return true;
            }
            if (dfs(ni, nj, i, j, grid, c, m, n, visited)) {
                return true;
            }
        }
        return false;
    }

    private static void printVisited(boolean[][] visited) {
        for (boolean[] row : visited) {
            for (boolean b : row) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
