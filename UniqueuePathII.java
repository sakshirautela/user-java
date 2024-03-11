public class UniqueuePathII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        for(int i=1;i<n;i++){
            if(obstacleGrid[i-1][0]==0)
                dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            if(obstacleGrid[0][i-1]==0)
                dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        printss(dp);
        return dp[n-1][m-1];
    }
    private static void printss(int[][] dp) {
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
}
