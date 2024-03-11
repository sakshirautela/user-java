public class FiboDPTabulation {
    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];

        //step 1
        dp[0]=0;
        dp[1]=1;

        //step 2filling
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
