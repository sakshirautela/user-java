import java.util.HashMap;
import java.util.HashSet;

public class CountSubarraysWithKDistinctIntegers {
    static void main() {
        System.out.println(countSubarrays(new int[]{3,1,2,4}, 2, 1));
    }

    public static long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int j=0;
        for (int i = 0; i < n; i++) {
            while (j<i && set.size()>k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
                if(map.get(nums[j])==0){
                    set.remove(nums[j]);
                    map.remove(nums[j]);
                }
                j++;
            }
            boolean b=true;
            for(int key:map.keySet()){
                if(map.get(key)<m){
                    b=false;
                }
            }
            if(b && set.size()==k){
                res++;
            }
            set.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
        return res;
    }
}
