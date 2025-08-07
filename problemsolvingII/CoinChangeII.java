import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        System.out.println(change(500, new int[] { 3, 5, 7, 8, 9, 10, 11 }));
    }

    public static int changef(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
    public static int change(int amount, int[] coins) {
         int n= coins.length;
        int[] dp[] = new int[n+1][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return changeUtil(amount,coins,0,0,n,dp);
        
    }
    private static int changeUtil(int amount, int[] coins, int i, int val,int n, int[][] dp) {
        if(i==n){
            return val==amount?1:0;
        }
        if(val>amount){
            return 0;
        }
        if(dp[i][val] != -1) {
            return dp[i][val];
        }
        return dp[i][val]=changeUtil(amount, coins, i, val+coins[i], n,dp)+changeUtil(amount, coins, i+1, val, n,dp);
    
    }

    static {
        for (int i = 0; i < 500; i++) {
            changeFast(0, new int[] { 1, 1, 11, 1 });
        }
    }

    public static int changeFast(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}