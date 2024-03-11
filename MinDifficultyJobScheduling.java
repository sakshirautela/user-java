import java.util.Arrays;

public class MinDifficultyJobScheduling {
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d){
            return -1;
        }
        int dp[][]=new int[d+1][n];
        for(int i=0;i<n;i++){
            if(i==0){
                dp[1][i]=jobDifficulty[i];
            }else{
                dp[1][i]=Math.max(jobDifficulty[i],dp[1][i-1]);
            }
        }
        for(int i=2;i<d+1;i++){
            for(int j=i-1;j<n;j++){
                int job=jobDifficulty[j];
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=j;k>=i-1;k--){
                    job=Math.max(job,jobDifficulty[k]);
                    dp[i][j]=Math.min(job+dp[i-1][k-1],dp[i][j]);
                }
            }
        }                               
        printdp(dp);
        return dp[d][n-1];
    }
    static void printdp(int[][] dp) {
        for(int j=0;j<dp.length;j++){
            for(int i=0;i<dp[0].length;i++){
                System.out.print(dp[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        System.out.println(minDifficulty(new int[]{11,111,22, 222 ,33,333,44,444},6));
    }
}