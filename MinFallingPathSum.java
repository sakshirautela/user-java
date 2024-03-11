public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int i=0; i<m; i++){
            dp[0][i]=matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a=matrix[i][j]+dp[i-1][j];
                int b=Integer.MAX_VALUE;
                int c=Integer.MAX_VALUE;
                if(j-1>=0){
                    b=matrix[i][j]+dp[i-1][j-1];
                }
                if (j + 1 <m) {
                    c = matrix[i][j] + dp[i - 1][j +1];
                }
                dp[i][j]=Math.min(a,Math.min(b,c));
            }
        }
        for(int i = 1; i <m;i++){
            dp[n-1][i]=Math.min(dp[n-1][i],dp[n-1][i-1]);
        }
        printdp(dp);
        return dp[n-1][m-1];
    }
    private void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MinFallingPathSum obj=new MinFallingPathSum();
        System.out.println(obj.minFallingPathSum(new int[][]{{ 17, 82},{ 1, -44}}));
    }
}