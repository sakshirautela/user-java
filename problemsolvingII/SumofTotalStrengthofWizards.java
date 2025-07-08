import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumofTotalStrengthofWizards {
    public static void main(String[] args) {
        System.out.println(totalStrength(new int[] {1,3,1,2}));
    }

    public static int totalStrength(int[] strength) {
        int mod = 1_000_000_007;
        int n = strength.length;
        int sum=0;
        int[] presum = new int[n];
        for (int i = 1; i < n; i++) {
            sum=(sum+strength[i-1])%mod;
            presum[i] = (sum + presum[i - 1]) % mod;
        }
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            System.out.println(stack);
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            System.out.println(stack);
            while (!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            long contribution = mod;
            contribution = contribution * strength[i] % mod;
            total = (total + contribution) % mod;
        }

        return (int) total;
    }

    public int maxValueFast(int[][] events, int k) {
        if(k == 1) {
            int max = 0;
            for(int[] event : events) max = Math.max(max, event[2]);
            return max;
        }
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        for(int i = n - 1; i >= 0; i--) {
            int index = binarySearch(events, i + 1, n, events[i][1]);
            for(int j = k - 1; j >= 0; j--) dp[i][j] = Math.max(dp[i + 1][j], dp[index][j + 1] + events[i][2]);
        }
        return dp[0][0];
    }
    private static int binarySearch(int[][] events, int left, int right, int target) {
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(events[mid][0] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}