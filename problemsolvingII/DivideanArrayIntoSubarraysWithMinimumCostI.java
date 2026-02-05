public class DivideanArrayIntoSubarraysWithMinimumCostI {
    static void main() {
        System.out.println(minimumCost(new int[]{1, 2, 3, 12}));

    }

    public static int minimumCost(int[] nums) {
        int r = nums[0];
        int f = Integer.MAX_VALUE;
        int s = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < f) {
                s = f;
                f = nums[i];
            } else if (nums[i] < s) {
                s = nums[i];
            }
        }

        return r + f + s;
    }
}