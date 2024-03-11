public class BestTimeToSellStock {
    int maxProfit(int[] prices){
        int sellProfit=0;
        int buyPrice=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
           if(buyPrice<prices[i]){
                int profit=prices[i]-buyPrice;
                sellProfit=Math.max(profit, sellProfit);
           }
           else{
                buyPrice=prices[i];
           } 
        }
        return sellProfit;
    }
    public static void main(String[] args) {
        BestTimeToSellStock stck=new BestTimeToSellStock();
        int[] prices={ 7, 6, 4, 3, 1,6};
        System.out.println(stck.maxProfit(prices));

    }
}
