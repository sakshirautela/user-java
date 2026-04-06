public class MinimumIncreasetoMaximizeSpecialIndices {
    static void main() {
        System.out.println(minIncrease(new int[]{12,23,13,17,21,3}));
    }

    public static long minIncrease(int[] nums) {
        int n = nums.length;
        int oddSum = 0;
        for (int i = 1; i < n - 1; i++) {
            int pre = nums[i - 1];
            int next = nums[i + 1];
            int mid = nums[i];
            if (i % 2 == 0) {
                if (mid <= next || mid <= pre) {
                    oddSum += (Math.max(pre, next) + 1) - mid;
                }
            }
        }
        if(n%2==1){
            return oddSum;
        }
        int[][] dp = new int[2][n];
        minIncreaseEven(dp,nums,1,0,n);
        return 0;
    }

    private static int minIncreaseEven(int[][] dp, int[] nums, int i, int index, int n) {
        if(i>=n-1){
            return 0;
        }
        if(index==1){
            if(nums[i]>nums[i+1]){
                dp[0][i]+=0;
            }
        }
        minIncreaseEven(dp,nums,i+2,1,n);
        minIncreaseEven(dp,nums,i+3,0,n);
        return 0;
    }
}
