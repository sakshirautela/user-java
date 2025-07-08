import java.util.Arrays;
public class NumberofSubsequencesThatSatisfytheGivenSumCondition {
    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{},7));
    }
    public static int binarysearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int result = 0;
        for (int left = 0; left < n; ++left) {
            int remaining = target - nums[left];
            int right = binarysearch(nums, remaining) - 1;
            if (left <= right) {
                result = (result + power[right - left]) % mod;
            }
        }

        return result;
    }
    public int numSubseq2(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int n =nums.length;
        int left=0;
        int right = n-1;
        int[] pw = new int[n];
        pw[0] = 1;
        for(int i=1  ; i<n ; i++){
            pw[i] = (pw[i-1]*2)%mod;
        }
        int ans=0;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans=(ans+pw[right-left])%mod;
                left++;
            }
            else
                right--;

        }
        return ans;
    }
    
}
