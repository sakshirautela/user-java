
public class SticklerTheifGFG {
    public static void main(String[] args) {
        System.out.println(findMaxSum(new int[]{}));
    }
    public static int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[1]=arr[0];
        for (int i = 2; i <=n; i++) {
            dp[i]=Math.max(arr[i-1]+dp[i-2],dp[i-1]);
        }
        return dp[n];
    }
    static int maxLoot(int[] hval) {
        int n = hval.length;

        if (n == 0)
            return 0;
        if (n == 1)
            return hval[0];

        // Set previous 2 values
        int secondLast = 0, last = hval[0];

        // Compute current value using previous
        // two values. The final current value
        // would be our result
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(hval[i] + secondLast, last);
            secondLast = last;
            last = res;
        }

        return res;
    }
}
