import java.util.HashMap;

public class CountNumberofMaximumBitwiseORSubsets {
    public static void main(String[] args) {
        System.out.println();
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int or = 0;
        for (int i = 0; i < n; i++) {
            or = or | nums[i];
        }
        return countMaxOrSubsetsUtill(nums, 0, or, 0, n);
    }

    private int countMaxOrSubsetsUtill(int[] nums, int i, int or, int curr, int n) {
        if (i == n) {
            return (or == curr) ? 1 : 0;
        }
        return countMaxOrSubsetsUtill(nums, i + 1, or, curr | nums[i], n) + countMaxOrSubsetsUtill(nums, i + 1, or, curr, n);
    }

    static int maxOr = 0;
    static int count = 0;

    public int countMaxOrSubsets2(int[] nums) {


        maxOr = 0;
        count = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        dfs(nums, 0, 0);
        return count;
    }

    private static void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, currentOr | nums[index]);
        dfs(nums, index + 1, currentOr);
    }


}
