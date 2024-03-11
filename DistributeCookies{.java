class DistributeCookies {
    public static int distributeCookies(int[] cookies, int k) {
        int n=cookies.length;
        int[][] dp=new int[n+1][k+1];
        int[] sum=new int[n];
        sum[0]=cookies[0];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+cookies[i];
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                if(sum[i-1]%j==0){
                    dp[i][j]=sum[i-1]/j;
                }
                else{
                    dp[i][j]=(sum[i-1]/j)+1;
                }
            }
        }
        printdp(dp);
        return dp[n][k];
    }
    public static void main(String[] args) {
        int[] cookies = {8,15,10,20,8};
        System.out.println(distributeCookies(cookies,2));
    }
    public static void printdp(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.println(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}