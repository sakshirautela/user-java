import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WaystoExpressanIntegerasSumofPowers {
    public static void main(String[] args) {
        System.out.println(numberOfWays(10, 2));
    }

    static int mod = 1000000007;

    public static int numberOfWays(int n, int x) {
        int dp[][]=new int[n+1][n+1];
        dp[0][0]=1;
        for (int i = 1; i <=n ; i++) {
            int power= (int) Math.pow(i,x);
            for (int j = 1; j <=n ; j++) {
                dp[i][j]=dp[i-1][j];
                if(j>=power){
                    dp[i][j]=(dp[i][j]+dp[i-1][j-power])%mod;
                }
            }
        }
        return dp[n][n];
    }
    public int numberOfWaysFast(int n, int x) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; Math.pow(i,x) <= n; i++) {
            int power = (int)Math.pow(i,x);
            for (int j = n; j >= power; j--) {
                dp[j] += dp[j - power];
            }
        }
        return (int) (dp[n] % 1_000_000_007);

    }
}