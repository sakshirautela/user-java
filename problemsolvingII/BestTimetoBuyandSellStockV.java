public class BestTimetoBuyandSellStockV {
    public static void main(String[] args) {
        System.out.println();
    }

    public long maximumProfit(int[] prices, int k) {
        int buy = prices[0];
        long profit = 0;
        int curr=buy;
        boolean inbetween = true;
        int n=prices.length;
        for (int i = 1; i < n; i++) {
            if(prices[i]>=curr){
                if(inbetween){
                    curr=prices[i];
                }else{

                }
            }
        }
        return profit;
    }
}
