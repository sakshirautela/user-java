
public class MaximumNumberofFishinaGrid {
    public static void main(String[] args) {
        System.out.println(findMaxFish(new int[][] { {} }));
    }

    public static int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] > 0 && !visited[r][c]) {
                    result = Math.max(result, findMaxFishHelper(grid, r, c, m, n, visited));
                }
            }
        }
        return result;
    }

    private static int findMaxFishHelper(int[][] grid, int r, int c, int m, int n, boolean[][] visited) {
        if (r < 0 || c < 0 || c >= n || r >= m || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        return (grid[r][c] + findMaxFishHelper(grid, r, c + 1, m, n, visited)
                + findMaxFishHelper(grid, r, c - 1, m, n, visited) + findMaxFishHelper(grid, r + 1, c, m, n, visited)
                + findMaxFishHelper(grid, r - 1, c, m, n, visited));
    }

    public int findMaxFish2(int[][] grid) {

        int maxFish = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] > 0) {

                    int fishInRegion = bfs(grid, i, j);

                    maxFish = Math.max(maxFish, fishInRegion);
                }

            }
        }

        return maxFish;

    }

    public int bfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        int fish = grid[i][j];

        grid[i][j] = 0;
        fish += bfs(grid, i + 1, j);
        fish += bfs(grid, i - 1, j);
        fish += bfs(grid, i, j + 1);
        fish += bfs(grid, i, j - 1);

        return fish;
    }
}
