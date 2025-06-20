
public class BestTimeToSellStockII {

    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        BestTimeToSellStockII stck=new BestTimeToSellStockII();
        int[] prices={ 7, 6, 4, 3, 1,6};
        System.out.println(stck.maxProfit(prices));

    }
}
