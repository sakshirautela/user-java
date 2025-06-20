
public class MinimumPairRemovaltoSortArrayI {

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{3, 1, 2, 4, 5}));
        System.out.println(minimumPairRemoval(new int[]{1, 3, 2, 3, 1}));
        System.out.println(minimumPairRemoval(new int[]{1, 2, 3, 4, 5}));
    }

    public static int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (isSorted(nums, n)) {
            return 0;
        }

        // Find the length of the Longest Increasing Subsequence (LIS)
        int lisLength = findLISLength(nums, n);

        // To make the array sorted, remove the elements that are not part of the LIS
        return n - lisLength;
    }

    private static boolean isSorted(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Find the length of the Longest Increasing Subsequence (LIS)
    private static int findLISLength(int[] nums, int n) {
        int[] dp = new int[n];
        int maxLIS = 1;

        // Initialize dp array where each element starts as a subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The maximum value in dp will be the length of the LIS
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }
}
