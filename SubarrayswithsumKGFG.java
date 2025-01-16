import java.util.HashMap;

public class SubarrayswithsumKGFG {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {}, 6));
    }

    public static int countSubarrays(int arr[], int k) {
        // code here
        int n = arr.length, sum = 0;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int res = 0;
        for (int j = 0; j < n; j++) {
            sum+=arr[j];
            if(sum==k){
                res++;
            }
            if(hm.containsKey(sum-k)){
                res+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault( sum,0)+1);
        }
        return res;
    }
}