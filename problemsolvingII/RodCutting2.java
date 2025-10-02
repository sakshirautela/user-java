public class RodCutting2 {
    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
    }

    public static int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[][] dp=new int[n+1][n+1];

        int[] cuts=new int[n];
        for (int i = 1; i <=n ; i++) {
            cuts[i-1]=i;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n ; j++) {
                if(j>=cuts[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j-cuts[i-1]]+price[i-1],dp[i-1][j-1]);
                }else{
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        print(dp);
        return dp[n][n];
    }

    private static void print(int[][] dp) {
    }
}
