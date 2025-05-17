import java.util.Arrays;

public class ShortestPathinaGridwithObstaclesEliminationLeetcode {
    public static void main(String[] args) {
        System.out.println(shortestPath(new int[][]{{}},3));
    }
    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length; int n = grid[0].length;
        int[][][] dp=new int[m][n][k+1];
        for (int[][] is : dp) {
            for (int[] i : is) {
                Arrays.fill(i,Integer.MAX_VALUE);
            }
        }
        int ans=(shortestPathUtil(grid, 0,0,0,m,n,k,dp));
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    private static int shortestPathUtil(int[][] grid, int i, int j,int steps, int m, int n, int k, int[][][] dp) {
        if(i<0||i==m||j<0||j==n||grid[i][j]==2){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j][k]!=Integer.MAX_VALUE){
            return dp[i][j][k];
        }
        k-=grid[i][j];
        if(k<0){
            return Integer.MAX_VALUE;
        }
        if(m-1==i && n-1==j){
            return steps;
        }
        int a=Integer.MAX_VALUE;
        grid[i][j]=2;
        a=shortestPathUtil(grid, i+1, j, steps+1, m, n, k, dp);
        a=Math.min(a,shortestPathUtil(grid, i, j+1, steps+1, m, n, k, dp));
        a=Math.min(a,shortestPathUtil(grid, i, j-1, steps+1, m, n, k, dp));
        a=Math.min(a,shortestPathUtil(grid, i-1, j, steps+1,m, n, k, dp));
        return dp[i][j][k]=a;
    }
}