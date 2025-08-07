public class SmallestSubarraysWithMaximumBitwise {
    public static void main(String[] args) {
        int[] res = smallestSubarrays(new int[]{1, 0, 2, 1, 3});
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int preor[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            preor[i] = (i == n - 1) ? nums[i] : Math.max(nums[i], preor[i + 1] | nums[i]);
        }
        for (int i = 0; i < n; i++) {
            //res[i] = getSmallestSubArray(nums, i + 1, nums[i], 1, n, preor[i])[0];
            int or=nums[i];
            int idx=i+1;
            while (idx<n && or <preor[i]){
                or|=nums[idx];
                idx++;
            }
            res[i]=idx-i;
        }
        return res;
    }
}