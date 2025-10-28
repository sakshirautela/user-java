import java.util.HashSet;
import java.util.Set;

public class LongestBalancedSubarrayI {
    public static void main(String[] args) {
        System.out.println(longestBalanced(new int[]{3,2,2,5,4}));
    }
        public static int longestBalanced(int[] nums) {
            int n = nums.length;
            int maxLen = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                int evenCount = 0;
                int oddCount = 0;

                for (int j = i; j < n; j++) {
                    if (!seen.contains(nums[j])) {
                        if (nums[j] % 2 == 0) evenCount++;
                        else oddCount++;
                        seen.add(nums[j]);
                    }

                    if (evenCount == oddCount) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }

            return maxLen;
        }
}
