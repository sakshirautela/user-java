public class PartitionArrayIntoTwoArraystoMinimizeSumDifference {
    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};
        System.out.println(minimumDifference(nums)); // Output: 1
    }
    public static int minimumDifferenceTLE(int[] nums) {
       int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int result[] = { Integer.MAX_VALUE };
        minimumDifferenceHelper(nums, n / 2,0, sum, result, n - 1);
        return result[0];
    }

    private static void minimumDifferenceHelper(int[] nums, int n, int sum, int totalsum, int[] result, int i) {
        if (n == 0) {
            result[0] = Math.min(result[0], Math.abs(totalsum - 2 * sum));
            return;
        }
        if(i==0){
            return ;
        }
        minimumDifferenceHelper(nums, n - 1, sum + nums[i], totalsum, result, i - 1);
        minimumDifferenceHelper(nums, n, sum, totalsum, result, i - 1);
    }
    @SuppressWarnings("unused")
    public static int minimumDifference(int[] nums) {
        int n=nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return 0;
    }
}
