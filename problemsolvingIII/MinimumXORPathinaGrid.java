package problemsolvingIII;

import java.util.Arrays;

public class MinimumXORPathinaGrid {
    static void main() {
        System.out.println();
    }
    public static int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return minCostUtill(0,0,n,m,grid,dp);
    }

    private static int minCostUtill(int i, int j, int n, int m, int[][] grid, int[][] dp) {
        if (i>=n && j>=m) {
            return 0;
        }
//        if(dp[i][j]!=-1){
//            return dp[i][j];
//        }
        int cost=grid[i][j];
        cost|=minCostUtill(i+1,j,n,m,grid,dp);
        cost=Math.min(cost,cost|minCostUtill(i,j+1,n,m,grid,dp));
        return cost;
    }
}
