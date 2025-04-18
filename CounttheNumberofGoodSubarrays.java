import java.util.HashMap;
import java.util.Map;

public class CounttheNumberofGoodSubarrays {
    public static void main(String[] args) {
        System.out.println(countGood(new int[]{},3));
    }
    public static long countGood(int[] nums, int k) {
        int pairs=0;
        int right=-1;
        HashMap<Integer,Integer> freq =new HashMap<>();
        long result=0;
        int n=nums.length;
        for (int i = 0; i <n; i++) {
            while(pairs<k && right+1<n){
                right++;
                pairs+=freq.getOrDefault(nums[right], 0);
                freq.put(nums[right], freq.getOrDefault(nums[right], 0)+1);
            }
            if(pairs>=k){
                result+=n-right;
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)-1);
            pairs-=freq.getOrDefault(nums[i], 0);
        }
        return result;
    }
    public long countGood2(int[] nums, int k) {
        if (nums.length < 2) {
            return 0L;
        }
        Map<Integer, Integer> countMap = new HashMap<>(nums.length, 0.99f);
        long goodSubArrays = 0L;
        long current = 0L;
        int left = 0;
        int right = -1;
        while (left < nums.length) {
            if (current < k) {
                if (++right == nums.length) {
                    break;
                }
          
                Integer num = nums[right];
                Integer count = countMap.get(num);
                if (count == null) {
                    count = 1;
                } else {
                    current += count;
                    if (current >= k) {
                        goodSubArrays += nums.length - right;
                    }
                    count = count + 1;
                }
                countMap.put(num, count);
            } else {
                Integer num = nums[left++];
                int count = countMap.get(num) - 1;
                if (count > 0) {
                    countMap.put(num, count);
                    current -= count;
                } else {
                    countMap.remove(num);
                }
                if (current >= k) {
                    goodSubArrays += nums.length - right;
                }
            }
        }
        return goodSubArrays;
    }
}