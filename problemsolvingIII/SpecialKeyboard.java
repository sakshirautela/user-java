package problemsolvingIII;

import java.util.ArrayList;

public class SpecialKeyboard {
    static void main() {
        System.out.println(optimalKeysDP(7));
    }
    public static int optimalKeysDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i-3; j++) {
                dp[i] = Math.max(dp[i], (i-j-1) *dp[j]);
            }
        }
        return dp[n];
    }
        public static int optimalKeys(int n) {
                // code here
            max=0;
            optimalKeysUtil(n-1,1,0);
            return max;
        }
static int max;
    private static void optimalKeysUtil(int n, int len,int paste) {
        if (n <= 0) {
            max=Math.max(max,len);
            return;
        }
        optimalKeysUtil(n-1,len+1,paste);
        if(n>=3) {
            optimalKeysUtil(n - 3, len+len, len);
        }
        if(paste>0) {
            optimalKeysUtil(n - 1, len + paste, paste);
        }
    }
}
