public class FindMinimumTimetoReachLastRoomI {
    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{0,4},{4,4}}));
    }
    public static int minTimeToReach(int[][] moveTime) {
        int m=moveTime.length;
        int n=moveTime[0].length;
        int[][] dp=new int[m][n];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+moveTime[i][0]+1;
        }
        for(int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+moveTime[0][i]+1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+moveTime[i][j]+1;
            }
        }
        print(dp);
        return dp[m-1][n-1]-moveTime[m-1][n-1];
    }
    private static void print(int[][] dp) {
        for (int[] is : dp) {
            for (int i : is) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}