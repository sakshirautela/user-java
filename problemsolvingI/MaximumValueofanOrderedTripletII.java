
public class MaximumValueofanOrderedTripletII {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[] { 12, 6, 1, 2, 7 }));
    }

    public static long maximumTripletValue(int[] nums) {
        long res = 0;
        int n = nums.length;
        int[] pre_max = new int[n];
        int[] post_max = new int[n];
        for (int i = 1; i < n; i++) {
            pre_max[i] = Math.max(pre_max[i - 1], nums[i - 1]);
            post_max[n - 1 - i] = Math.max(post_max[n - i], nums[n - i]);
        }
        for (int index = 1; index < n - 1; index++) {
            res = Math.max(res, (long) (pre_max[index] - nums[index]) * post_max[index]);
        }
        return res;
    }

    public long maximumTripletValue2(int[] nums) {
        long maxProduct = 0;
        int maxDiff = 0;
        int maxNum = 0;
        for (int num : nums) {
            maxProduct = Math.max(maxProduct, (long) maxDiff * num);
            maxNum = Math.max(maxNum, num);
            maxDiff = Math.max(maxDiff, maxNum - num);
        }
        return maxProduct > 0 ? maxProduct : 0;
    }
}
