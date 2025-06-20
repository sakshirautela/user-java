import java.util.Arrays;

public class EggDropWith2EggsandNFloors {
    public static void main(String[] args) {
        System.out.println(twoEggDropMath(5));
    }

    public static int twoEggDropMemo(int n) {
        int dp[][] = new int[n + 1][3];
        return getDrop(n, 2, dp);
    }

    private static int getDrop(int n, int k, int[][] dp) {
        if (n <= 1) {
            return n;
        }
        if (k == 1) {
            return n;
        }
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            // if breaks
            int breaks = getDrop(i - 1, k - 1, dp);
            // if not breaks
            int notbreaks = getDrop(n - i, k, dp);
            res = Math.min(res, 1 + Math.max(breaks, notbreaks));

        }
        return dp[n][k] = res;
    }

    public int twoEggDropBin(int n) {
        int[][] dp = new int[n+1][3];
        for(int[] ele: dp){
            Arrays.fill(ele, -1);
        }
        return twoEggDropBinUtill(n,2,dp);
    }
    public static int twoEggDropBinUtill(int n, int e, int[][] dp){
        if(n == 0 || n == 1 || e == 1){
            return n;
        }
        if(dp[n][e] != -1){
            return dp[n][e];
        }
        int ans = Integer.MAX_VALUE;
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int left = twoEggDropBinUtill(mid-1,e-1,dp);
            int right = twoEggDropBinUtill(n-mid,e,dp);
            int t = Math.max(left, right) + 1;
            ans = Math.min(ans, t);
            if(left < right){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return dp[n][e] = ans;
    }

    public static int twoEggDropMath(int n) {
        return (int) Math.ceil((Math.sqrt(1 + 8 * n) - 1) / 2.0);
    }

    public int twoEggDrop2(int n) {
        int res = n;
        for (int step = 1; step < n; step++) {
            int s = step;
            int cur = s;
            while (cur < n && s > 0) {
                cur += --s;
            }
            if (cur >= n) {
                res = Math.min(res, step);
            }
        }
        return res;
    }

    static int[] dp = new int[1001];

    public int twoEggDrop3(int n) {
        if (dp[n] == 0)
            for (int i = 1; i <= n; ++i)
                dp[n] = Math.min(dp[n] == 0 ? n : dp[n], 1 + Math.max(i - 1, twoEggDrop3(n - i)));
        return dp[n];
    }
}