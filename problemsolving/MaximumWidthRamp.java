
public class MaximumWidthRamp {
    public static int maxWidthRamp(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] <= nums[j]) {
                    result = Math.max(result, j - i);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.err.println(maxWidthRamp(new int[] {}));
    }
}
