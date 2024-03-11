public class CoinChange {
    public static void main(String[] args) {
        int coins[]={2};
        int amount=3;
        // System.out.println(tabulizationNways(coins, amount));
        System.out.println(coinChange(coins, amount,coins.length));
        System.out.println(tabulizationNcoins(coins,amount));


    }
    public static int coinChange(int coins[],int amount,int n){
        if(n==0 && amount !=0){
            return Integer.MAX_VALUE-1;
        }
        if(amount==0){
            return 0;
        }
        //if include
        if(amount>=coins[n-1]){
            int ans=1+coinChange(coins,amount-coins[n-1],n);
            int ans2=coinChange(coins,amount,n-1);
            return Math.min(ans,ans2);
        }
        else{
            return coinChange(coins,amount,n-1);
        }
    }
    public static int tabulizationNcoins(int coins[], int amount) {
        int n = coins.length ;
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for(int  i  =   1 ;  i <  amount+1; i++) {
            dp[ 0][i]  = Integer.MAX_VALUE-1 ;      
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                // valid or include
                if (coins[i - 1] <= j) {
                    dp[i][j] =Math.min(dp[i][j - coins[i - 1]] +1,dp[i - 1][j]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printfDp(dp);
        return dp[n][amount];
    }
    // public static int tabulizationNways(int coins[],int sum){
    //     int n=coins.length;
    //     int dp[][]=new int[coins.length+1][sum+1];
    //     for(int i=0;i<n;i++){
    //         dp[i][0]=1;
    //     }
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<sum+1;j++){
    //             //valid or include
    //             if(coins[i-1]<=j){
    //                 dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
    //             }
    //             else{
    //                 dp[i][j]=dp[i-1][j];
    //             }
    //         }
    //     }
    //     printfDp(dp);
    //     return dp[n][sum];
    // }
    private static void printfDp(int[][] dp) {
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
