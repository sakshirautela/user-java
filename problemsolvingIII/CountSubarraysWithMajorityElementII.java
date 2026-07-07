package problemsolvingIII;

import java.util.HashMap;

public class CountSubarraysWithMajorityElementII {
    static void main() {
        System.out.println(countMajoritySubarrays(new int[]{}, 3));
    }

    public static long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans=0;
        int sum=0;
        map.put(0, 1);
        int count=0;
        for (int i = 0; i < n; i++) {
            if(nums[i]==target){
                sum++;
                count+=map.getOrDefault(sum, 0);
            }else{
                sum--;
                count-=map.getOrDefault(sum, 0);
            }
            map.getOrDefault(sum,map.getOrDefault(sum,0)+1);
            ans+=count;
        }
        return ans;
    }
}
