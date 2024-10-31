public class MinimumCostPath{
    public static int minimumCostPath(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            dp[i][1]=dp[i-1][1]+grid[i-1][0];
        }
        for (int i = 1; i < m+1; i++) {
            dp[1][i]=dp[1][i-1]+grid[1][i-1];
        }
        for (int i = 2; i < n+1; i++) {
            for (int j = 2; j < m+1; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][m];
        
    }
    public static void main(String arga[]){
        System.out.println(minimumCostPath(new int[][]{{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}}));
    }
}