class PutMarbles {
    public static long putMarbles(int[] weights, int k) {
        return getMax(weights,k);
    }
    public static int getMax(int[] weights,int k) {
        int n=weights.length;
        int[][] dp=new int[k+1][weights.length+1];
        for (int i=1;i<k+1;i++){
            for (int j=1;j<n+1;j++){
                if(j>=i){
                    dp[i][j] = Math.max(dp[i][j -i ] + weights[j - 1], dp[i][j - 1]);

                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        printdp(dp);
        return dp[k][n];
        
    }
    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] weights = {1,3};
        System.out.println(putMarbles(weights,2));
    }
}