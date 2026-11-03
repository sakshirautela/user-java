package problemsolvingIII;

public class MinimumOperationstoReduceXtoZero {
    static void main() {
        System.out.println(minOperations(new int[]{1,1,4,2,3},5));
    }
    public static int minOperations(int[] nums, int x) {
        int n=nums.length;
        int[][]dp=new int[n+1][n+1];
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                dp[j][k]=-1;
            }
        }
        long a= minOperationsUtil(nums,0,n-1,x,dp);
        if(a==Integer.MAX_VALUE){
            return -1;
        }
        return Math.toIntExact(a);
    }

    private static long minOperationsUtil(int[] nums, int i, int j, int x, int[][] dp) {
        if(x==0){
            return 0;
        }
        if(x<0){
            return Integer.MAX_VALUE;
        }
        if(i>j){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return 1+Math.min(minOperationsUtil(nums,i+1,j,x-nums[i], dp),minOperationsUtil(nums,i,j-1,x-nums[j], dp));
    }
}
