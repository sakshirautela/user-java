public class CountSubarraysofLengthThreeWithaCondition {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{}));
    }
    public static int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ++ans;
            }
        }
        return ans;
    }
}
