
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[] {}));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] idx = new int[n];
        Arrays.sort(nums);
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j + 1];
                    idx[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }
        List<Integer> li = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i = idx[i]) {
            li.add(nums[i]);
        }
        return li;
    }

    public List<Integer> largestDivisibleSubset2(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        int[] ind = new int[n];
        int res = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ind[i] = i;
            dp[i] = 1;
            int limit = (arr[i] + 1) / 2;
            for (int j = 0; j < i && arr[j] <= limit; j++) {
                if (arr[i] % arr[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                    ind[i] = j;
                }
            }
            res = dp[i] > dp[res] ? i : res;
        }
        while (res != ind[res]) {
            ans.add(arr[res]);
            res = ind[res];
        }
        ans.add(arr[res]);
        Collections.reverse(ans);
        return ans;
    }
}
