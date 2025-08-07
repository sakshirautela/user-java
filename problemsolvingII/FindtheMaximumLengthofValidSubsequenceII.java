public class FindtheMaximumLengthofValidSubsequenceII {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[] { 1,4,2,3,1,4}, 3));
    }

    public static int maximumLength(int[] nums,int k) {
        int[][]  dp=new int[k][k];
        int res=0;
        for(int n:nums){
            int j=n%k;
            for(int i=0;i<k;i++){
                dp[i][j]=dp[j][i]+1;
                res=Math.max(res,dp[i][j]);

            }
        }
        return res;
    }
}