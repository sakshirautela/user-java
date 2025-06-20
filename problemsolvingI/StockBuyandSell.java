public class StockBuyandSell {
    public static void main(String[] args){
        System.out.println(stockBuySell(new int[]{}));
    }
    // Function to find the days of buying and selling stock for max profit.
    static int stockBuySell(int arr[]) {
        // code here
        int n=arr.length;
        int buy=Integer.MAX_VALUE;
        int profit=0;
        for (int i = 1; i < n; i++) {
            if(buy<arr[i]){
                profit+=arr[i]-buy;
            }else{
                buy=arr[i];
            }
        }
        return profit;
    }
}