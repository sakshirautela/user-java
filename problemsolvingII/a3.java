import java.util.*;

public class a3 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{5,4,7})); // 2
        System.out.println(longestSubsequence(new int[]{2,3,6})); // 3
        System.out.println(longestSubsequence(new int[]{0,1}));   // 1
    }

    public static int longestSubsequence(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) dp[i].put(arr[i], 1);
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev]) {
                    for (Map.Entry<Integer, Integer> e : dp[prev].entrySet()) {
                        int newAnd = e.getKey() & arr[i];
                        if (newAnd != 0) {
                            dp[i].put(newAnd, Math.max(dp[i].getOrDefault(newAnd, 0), e.getValue() + 1));
                        }
                    }
                }
            }
            for (int val : dp[i].values()) ans = Math.max(ans, val);
        }

        return ans;
    }
    public static int longestSubsequence2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int bit = 0; bit < 31; bit++) {
            int mask = 1 << bit;
            int[] lis = new int[n];
            int len = 0;
            for (int x : nums) {
                if ((x & mask) == 0) continue;
                int pos = lowerBound(lis, 0, len, x);
                lis[pos] = x;
                if (pos == len) len++;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }

    private static int lowerBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
