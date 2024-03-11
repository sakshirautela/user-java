public class TargetSumSubset {
    public static void main(String[] args) {
        int nums[]={4,2,7,1,3};
        int target=10;
        System.out.println(subsetExit(nums,target));
    }
    public static boolean subsetExit(int nums[],int target){
        int n=nums.length;
        boolean dp[][]=new boolean[n+1][target+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<target+1;i++){
            dp[0][i]=false;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                //include
                if(nums[i-1]<=j && dp[i-1][j-nums[i-1]]==true){
                    dp[i][j]=true;
                }
                //exclude condition
                if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        printDP(dp);
        return dp[n][target];
    }
    public static void printDP(boolean dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
