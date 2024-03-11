public class minPathSum64 {
    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        return PathSum(grid, 0, 0);
    }

    public static int PathSum(int[][] grid, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        int w1 = Integer.MAX_VALUE;
        int w2 = Integer.MAX_VALUE;
        if (x < grid.length - 1) {
            w1 = PathSum(grid, x + 1, y);

        }
        if (y < grid[0].length - 1) {
            w2 = PathSum(grid, x , y+1);

        }
        int minimum = Math.min(w1, w2);
        return grid[x][y] + minimum;
    }
}
