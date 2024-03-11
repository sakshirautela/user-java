class RobHouseII {
    public static int helper(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[1]=nums[0];
        for(int i=2; i<n+1; i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
    public static int rob(int[] nums) {
        int[] arr1=new int[nums.length-1]; 
        int idx=1;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=nums[idx++];
        }       
        int[] arr2=new int[nums.length-1];
        idx=0;
        for (int i = 0; i < arr1.length; i++) {
            arr2[i]=nums[idx++];
        }  
        int max1=helper(arr1);       
        int max2=helper(arr2);
        return Math.max(max1,max2);

    }
    public static void main(String[] args){
        System.out.println(rob(new int[]{2,1,1,2}));
    }
}