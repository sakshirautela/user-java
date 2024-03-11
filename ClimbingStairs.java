public class ClimbingStairs {
    public static void main(String[] args) {
        int n=5;
        System.out.println(recrsion(n));
        int[] ways=new int[n+1];
        System.out.println(memoization(n,ways));
        System.out.println(tabulization(n));

    }
    public static int recrsion(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return recrsion(n-1)+recrsion(n-2);//+recrsion(n-3);
    }
    
    public static int memoization(int n,int[] ways) {
        if (n == 0) {
            return 1;
        }
        if(n<0){
            return 0;
        }
        if (ways[n] != 0) {
            return ways[n];
        }
        return ways[n]=memoization(n - 1,ways) + memoization(n - 2,ways);// +recrsion(n-3);
    }
    public static int tabulization(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            if(i==1 ){
                dp[i] = dp[i-1]+0;
            } 
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
}
