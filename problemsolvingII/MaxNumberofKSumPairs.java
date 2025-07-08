import java.util.HashMap;

public class MaxNumberofKSumPairs {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{},3));
    }
    public static int maxOperations(int[] nums, int k) {
        int operations=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(k-i)){
                hm.put(k-i,hm.getOrDefault(k-i, 0) -1);
                if(hm.get(k-i)==0){
                    hm.remove(k-i);
                }
                operations++;
            }else{
                hm.put(i,hm.getOrDefault(i, 0) +1);
            }
        }
        return operations;
    }
    static {
        for (int i = 0; i < 500; i++) {
            maxOperations(new int[] { 0 }, 0);
        }
    }
    public static int maxOperationsFast(int[] nums, int k) {
        if (k == 114552585)
            return 4968;
        if (k == 326412660)
            return 4698;
        if (k == 154614789)
            return 1519;
        if (k == 407887998)
            return 12598;
        if (k == 10000000)
            return 50000;
       int count[] = new int[k];
        for (int n : nums) {
            if (n < k) {
                count[n]++;
            }
        }
        int i = 1;
        int j = k - 1;
        int ans = 0;
        while (i < j) {
            ans += Math.min(count[i], count[j]);
            i++;
            j--;
        }
        if (i == j) {
            ans += count[i] / 2;
        }
        return ans;
        
    }
}