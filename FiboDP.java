public class FiboDP{ //Memonization
    public static int fibo(int n,int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        return dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
    }
    public static void main(String[] args) {
        int n=6;
        int[] dp=new int[n+1];
        System.out.println(fibo(n,dp));
    }
}