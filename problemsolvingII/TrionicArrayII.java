public class TrionicArrayII {
    static void main() {
        System.out.println(maxSumTrionic(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static long maxSumTrionic(int[] nums) {
        int n = nums.length;
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int[] dp3 = new int[n];
        for (int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]) {
                dp1[i] = Math.max(dp0[i - 1],dp1[i-1]+nums[i]);
                dp2[i] = Math.max(dp1[i - 1],dp2[i-1]+nums[i]);
                dp3[i] = Math.max(dp2[i - 1],dp3[i-1]+nums[i]);
            }
            if(nums[i] > nums[i-1]) {
                dp0[i] = dp0[i-1]+nums[i];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max=Math.max(max,dp3[i]);
        }
        return max;
    }
}
