import java.util.Arrays;

public class NumRollsToTarget {
    public static int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        helpers(n,k,target,dp);
        printdp(dp);
        return dp[n][target];
    }
    public static int helpers(int n, int k, int target,int dp[][]){
        if(n*k<target){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(dp[n][target]!=-1){
            return (dp[n][target]);
        }
        int ways = 0;
        for(int i = 1; i<=Math.min(k,target-1); i++){
            ways=(ways+helpers(n-1,k,target-i,dp))%1000000007;
        }
        dp[n][target]=ways;
        return ways;
    }
    public static void main(String[] args){
        System.out.println(numRollsToTarget(2,6,7));
    }
    public static int numRollsToTarget2(int n, int k, int target){
        if(n==1 &&   k==1 && target<k){  
            return 1;
        }
        int dp[][]=new int[n+1][target+1];
        dp[0][0]=1;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=target; j++){
                for(int a=1;a<=k;a++){
                    if(j-a>=0){
                        dp[i][j]=(dp[i][j]+dp[i-1][j-a])% 1000000007;
                    }
                }
            }
        }
        return dp[n][target];
    }
    public static void printdp(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}