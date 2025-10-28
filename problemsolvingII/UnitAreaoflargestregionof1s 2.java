public class UnitAreaoflargestregionof1s {
    public static void main(String[] args) {
        findMaxArea(new int[][]{{}});
    }
    // Function to find unit area of the largest region of 1s.
    public static int findMaxArea(int[][] grid) {
        // Code here
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, i, j, m, n, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int area = 1;

        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            area += dfs(grid, i + rowDir[k], j + colDir[k], m, n, visited);
        }

        return area;
    }
}