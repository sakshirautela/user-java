import java.util.PriorityQueue;

public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        int buy = prices[0];
        int sell = prices[0];
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        boolean isselled=false;
        for (int i = 1; i < n; i++) {
            if (sell < prices[i]) {
                sell = prices[i];
                isselled=false;
            } else {
                if(!isselled){
                    isselled=true;
                    pq.add(sell-buy);
                }
                buy =prices[i];
                    sell=buy;
            }
        }
        if(!isselled){
            isselled=true;
            pq.add(sell-buy);
        }
        int k=2;
        System.out.println(pq);
        while (!pq.isEmpty() && k>0){
            result+=pq.remove();
            k--;
        }
        return result;
    }
}
