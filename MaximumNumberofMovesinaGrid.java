public class MaximumNumberofMovesinaGrid {
    public static int maxMoves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=maxMovesHelper(0, 0, m, n, grid, 0, -1)
        return 0;
    }
    private static int maxMovesHelper(int i, int j, int m, int n, int[][] grid, int k,int prev) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]<=prev){
            return k;
        }
        prev=grid[i][j];
        
    }
    public static void main(String[] args){
        System.out.println(maxMoves(new int[][]{{}}));
    }
}