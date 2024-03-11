import java.util.Arrays;

public class CatalanNumber {
    public static void main(String[] args) {
        int n=4;
        //System.out.println(catalanNumber(n));
        // int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        //System.out.println(catalanMemo(n,dp));
        System.out.println(catalanTabulization(n));
    }
    public static int catalanNumber(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanNumber(n-i-1)*catalanNumber(i);
        }
        return ans;
    }
    public static int  catalanMemo(int n,int[] dp) {
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanNumber(n-i-1)*catalanNumber(i);
        }
        return dp[n]=ans;
    }
    public static int catalanTabulization(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<=i-1;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }
        return dp[n];
    }
}
