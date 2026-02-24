import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MinimumRemovalstoBalanceArray {
    void main() {
        System.out.println(minRemoval(new int[]{4,6},2));
    }

    public static int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int result=0;
        Arrays.sort(nums);
        for (int l = 0; l <n; l++) {
            long num= (long) nums[l] * k;
            int end=search(num,nums);
            result=Math.max(result,end-l);
        }
        return n-result;
    }

    private static int search(long num, int[] nums) {
        int lo=0;
        int hi=nums.length;
        while (lo<hi) {
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<=num) {
                lo=mid+1;
            }else {
                hi=mid;
            }
        }
        return lo;
    }
    public static int minRemovalFast(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return nums.length - maxLen;
    }
}