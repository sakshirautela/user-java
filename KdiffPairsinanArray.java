import java.util.Arrays;
import java.util.HashMap;

public class KdiffPairsinanArray {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{},4));
    }
    public static int findPairs(int[] nums, int k) {
        int n=nums.length;
        if(n<=1){
            return 0;
        }
        Arrays.sort(nums);
        int i=0,j=1;
        int pairs=0;
        while (i<j&& j<n) {
            if(Math.abs(nums[i]-nums[j])<k){
                j++;
                continue;
            }
            else if(Math.abs(nums[i]-nums[j])==k){
                pairs++;
            }
            j=i;
            while (j<n&&nums[i]==nums[j]) {
                j++;
            }
            i=j;
            j++;
        }
        return pairs;
    }
    public int findPairs2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int num : map.keySet()) {
            if (k == 0 && map.get(num) >= 2) {
                count++;
            }
            if (k != 0 && map.containsKey(num + k)) {
                count++;
            }
        }
        return count;
    }
}