import java.util.Arrays;

public class NwaysToStaySamePlace {
    private static int mod=(int) 10e7;
    public static int numWays(int steps, int arrLen) {
        int dp[][]=new int[steps+1][arrLen+1];
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i],-1);
        }
        return rec(steps, 0,arrLen,0, 0,dp);
    }
    public static int rec(int steps,int st,int arrLen ,int i,int cost,int[][] dp){
        if(st==steps || i==arrLen || i==-1){
            if(cost==0) return 1;
            return 0;
        }
        if(dp[st][cost]!=-1){
            return dp[st][cost];
        }
        int a=(rec(steps, st+1,arrLen,i+1, cost+1,dp))%mod;
        int b=(rec(steps,st+1, arrLen,i-1, cost-1,dp))%mod;
        int c=(rec(steps,st+1,arrLen, i, cost,dp))%mod;
        return dp[st][cost]=(a+b+c)%mod;
    }
    public static void main(String[] args){
        System.out.println(numWays(6,7));
    }
}