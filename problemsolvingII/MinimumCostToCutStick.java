public class MinimumCostToCutStick {
    public static void main(String[] args) {
        System.out.println(minCost(4, new int[]{}));
    }

    public static int minCost(int n, int[] cuts) {
        int l = cuts.length;
        int[][] dp = new int[l + 1][n + 1];
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <n+1 ; j++) {
                for (int k = 0; k <l ; k++) {
//                    dp[i][j]= Math.min(dp[i][k] + dp[k][j]) + (j - i);
                }
            }
        }
        return dp[l][n];
    }
}