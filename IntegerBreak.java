class IntegerBreak {
    public static int integerBreak(int n) {
        if(n<=3){
            return 2;
        }
        if(n==4){
            return 4;
        }
        int a=1;
        while (n>4) {
            n=n-3;
            a=a*3;
        }
        a=a*n;
        return a;
    }
    public static void main(String[] args) {
        System.out.println(integerBreak(25));
    }
    public int integerBreak2(int n) {
        if(n==2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 1; j <= i/2 ; j++) {
                dp[i] = Math.max(j*(i-j),Math.max(j*dp[i-j],dp[i]));
            }
        }
        return dp[n];
    } 
}