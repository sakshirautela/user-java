import java.util.ArrayList;

public class MaximumProfitfromTradingStockswithDiscounts {
    public static void main(String[] args) {
        System.out.println(maxProfit(4,new int[]{},new int[]{},new int[][]{},3));
    }
    public static int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        return maxProfitUtill(n,0,present,future,hierarchy,budget,false,graph);
    }

    private static int maxProfitUtill(int n, int par, int[] present, int[] future, int[][] hierarchy, int budget, boolean isbuy, ArrayList<ArrayList<Integer>> graph) {

        for(int child:graph.get(par)){

        }
        return 0;

    }
}