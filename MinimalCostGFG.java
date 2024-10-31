public class MinimalCostGFG {
    public static int minimizeCost(int k, int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        dp[1]=Math.abs(arr[0]-arr[1]);
        for (int i = 2; i <n ; i++) {
            int cost=Integer.MAX_VALUE;
            for(int j=Math.max(0,i-k);j<i;j++){
                if(Math.abs(arr[i]-arr[j])+dp[j]<cost){
                    cost=Math.abs(arr[i]-arr[j])+dp[j];
                }
            }
            dp[i]=cost;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }
        return dp[n-1];
    }
    public static void main(String rags[]){
        System.out.println(minimizeCost(3,new int[]{10, 50, 40, 30, 20}));
    }
}