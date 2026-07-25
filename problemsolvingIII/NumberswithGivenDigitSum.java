package problemsolvingIII;

import java.util.Arrays;

public class NumberswithGivenDigitSum {
    public static void main(String[] args) {
        System.out.println(countWays(2,2));
    }
        public static int countWays(int n, int sum) {
            // code here
            int result=0;
            for (int i = 1; i <= 9; i++) {
                if(i<=sum){
                    result+=countWaysUtill(1,i,sum,n);
                }
            }
            return (result==0)?-1:result;
        }

    private static int countWaysUtill(int i, int s, int sum, int n) {
        if(i==n){
            return (s==sum)?1:0;
        }
        if(sum==s){
            return 1;
        }else if(s>sum){
            return 0;
        }
        int result=0;
        for(int j=0;j<=9;j++){
            result+=countWaysUtill(i+1,s+j,sum,n);
        }
        return result;
    }
    public static int countWaysMemo(int n, int sum) {
        // code here
        int result=0;
        int[][] dp=new int[n+1][sum+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        for (int i = 1; i <= 9; i++) {
            if(i<=sum){
                result+=countWaysUtillMemo(1,i,sum,n,dp);
            }
        }
        return (result==0)?-1:result;
    }

    private static int countWaysUtillMemo(int i, int s, int sum, int n, int[][] dp) {
        if(i==n){
            return (s==sum)?1:0;
        }
        if(sum==s){
            return 1;
        }else if(s>sum){
            return 0;
        }
        if(dp[i][s]!=-1){
            return dp[i][s];
        }
        int result=0;
        for(int j=0;j<=9;j++){
            result+=countWaysUtillMemo(i+1,s+j,sum,n, dp);
        }
        return dp[i][s]=result;
    }
    public static int countWaysBottomUpDP(int n, int sum) {
        // code here
        int result=0;
        int[][] dp=new int[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                for(int digit=0;digit<=9;digit++){
                    if(digit<=j) {
                        dp[i][j] += dp[i-1][j - digit];
                    }
                }
            }
        }
        for(int i=1;i<=9;i++){
            if(sum>=i){
                result+= dp[n-1][sum-i];
            }
        }
        return (result==0)?-1:result;
    }
}
