public class MaximumDifferenceBetweenAdjacentElementsinaCircularArray {
    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{}));
    }
    public static int maxAdjacentDistance(int[] nums) {
        int diff=0;
        int n=nums.length;
        for (int i = 1; i < n; i++) {
            diff=Math.max(diff,Math.abs(nums[i]-nums[i-1]));
        }
            diff=Math.max(diff,Math.abs(nums[0]-nums[n-1]));
        return diff;
    }
}