public class MinimumPartitioning {
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        System.out.println(minPartition(nums));

    }
    public static int minPartition(int nums[]) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int W=sum/2;
        int dp[][]=new int[n+1][W+1];
        //bottom up approach
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j-nums[i-1]]+nums[i-1],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum2=dp[n][W];
        int sum1=sum-sum2;
        return Math.abs(sum1-sum2);
    }
}
