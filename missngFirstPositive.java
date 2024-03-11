import java.util.Arrays;

public class missngFirstPositive {
    public static void main(String[] args) {
        int[] nums = { 7, 8, 9, 11, 12 };
        System.out.println(firstMissingPositive(nums));
    }
    
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums[nums.length - 1];
        int tsum = n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            sum = sum + nums[i];
        }
        int missing = tsum - sum;
        if (missing == 0 && isPresent(nums, 0)) {
            missing = n + 1;
        }
        return (missing);
    }

    private static boolean isPresent(int[] nums, int i) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
