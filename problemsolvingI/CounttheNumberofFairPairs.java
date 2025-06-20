
import java.util.Arrays;

public class CounttheNumberofFairPairs {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (lower <= nums[i] + nums[j] && nums[i] + nums[j] <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    public long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    // Calculate the number of pairs with sum less than `value`.
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[] {}, 3, 6));
    }

    public long countFairPairs3(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long pairsWithUpper = findLessThanEqualTo(nums, upper);
        long pairsWithLowerMinus1 = findLessThanEqualTo(nums, lower - 1);
        return pairsWithUpper - pairsWithLowerMinus1;
    }

    private long findLessThanEqualTo(int[] nums, int targetSum) {
        int n = nums.length;
        long pairs = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (nums[left] + nums[right] <= targetSum) {
                pairs += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }
}
