public class SwiminRisingWater {
    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][]{}));
    }

    public static int swimInWater(int[][] grid) {
        return swimInWaterDFS(grid, 0, 0, grid.length, grid[0].length, 0);
    }

    private static int swimInWaterDFS(int[][] grid, int i, int j, int m, int n, int steps) {
        if(i==n-1 && j==m-1){
            return steps;
        }
        if(i<0 ||j<0|| i>=m||j>=n){
            return Integer.MAX_VALUE;
        }
        swimInWaterDFS(grid, i, j, m, n, steps);
        return 0;
    }
}