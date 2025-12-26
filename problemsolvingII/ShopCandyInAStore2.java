import java.util.ArrayList;
import java.util.Arrays;

public class ShopCandyInAStore2 {
    public static void main(String[] args) {
        System.out.println(minMaxCandy(new int[]{9 ,13 ,4 ,17 ,7 ,13},1));
    }
    public static ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(prices);
        int min = 0;
        int max = 0;
        int n = prices.length;
        int free=0;
        int idx=0;
        while (free<n){
                max+=prices[n-1-idx];
                min+=prices[idx];
                free+=k+1;
                idx+=1;
        }
        res.add(min);
        res.add(max);
        return res;
    }
}
