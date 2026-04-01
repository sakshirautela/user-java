public class BuyStockwithTransactionFee {
    static void main() {
        System.out.println(maxProfitOptimize(new int[]{7, 1, 5, 3, 6, 4}, 1));
    }

    public static int maxProfitOptimize(int arr[], int k) {
        int n = arr.length;
        int tbuy=-arr[0];
        int tsell=0;
        for (int i = 0; i < n; i++) {
            int buy=Math.max(tsell-arr[i],tbuy);
            int sell=Math.max(tbuy+arr[i]-k,tsell);
            tbuy=buy;
            tsell=sell;
        }
        return tsell;
    }
        public static int maxProfit(int arr[], int k) {
        // Code here
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1]-arr[i]);
            dp[i][1] = Math.max(dp[i + 1][1], dp[i + 1][0] + arr[i]-k);
        }
        return dp[0][0];
    }
}
