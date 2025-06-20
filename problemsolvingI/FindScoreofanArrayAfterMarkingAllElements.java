
import java.util.Arrays;

public class FindScoreofanArrayAfterMarkingAllElements {
    public long findScore2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean[] marked = new boolean[n];
        long result = 0;

        for (int[] arr : dp) {
            int val = arr[0];
            int ind = arr[1];

            if (!marked[ind]) {
                result += val;

                marked[ind] = true;
                if (ind > 0)
                    marked[ind - 1] = true;
                if (ind < n - 1) 
                    marked[ind + 1] = true;
            }
        }

        return result;
    }
    public long findScore(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] < nums[i]) {
                i++;
            }
            for (int j = i; j >= start; j -= 2) {
                res += nums[j];
            }
        }
        return res;
    }
}
