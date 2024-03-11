public class UnboundedKnapsack {
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(tabulization(val,wt,W));
    }
    public static int tabulization(int val[],int wt[],int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int value=val[i-1];
                int weight=wt[i-1];
                if(weight<=j){ //include conditions
                    int include=dp[i][j-weight]+value;
                    int exclude = dp[i - 1][j];
                    dp[i][j]=Math.max(include,exclude);
                }
                else{
                    int exclude = dp[i - 1][j ];
                    dp[i][j]=exclude;
                }
            }
        }
        printDP(dp);
        return dp[n][W];
    }
    public static void printDP(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
