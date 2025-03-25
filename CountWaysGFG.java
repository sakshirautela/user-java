public class CountWaysGFG {
    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
    static int countWays(int n) {
        // your code here
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}