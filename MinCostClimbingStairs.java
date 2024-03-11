class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        // int n = cost.length;
        // int[] dp = new int[n+1];  
        // for ( i nt i=2; i<n+1; i++){
        //     dp[i]  =   M at h .m in(dp[i -2]+cost[i-2],dp[i-1]+cost[i-1]);
        // }         
        // return dp[n];

        //why we can update the cost 
        //cost[i]+=Math.min(cost[i-1],cost[i-2]);
        int n=cost.length;
        for(int i=2; i<n;i++){
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[n-1],cost[n-2]);
    }
    public static void main(String[] args){
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}