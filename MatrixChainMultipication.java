import java.util.Arrays;

public class MatrixChainMultipication {
    public static void main(String[] args) {
        int cost[]={1,2,3,4,3};
        System.out.println(MinCost(cost,1,cost.length-1));
        System.out.println(MinCostTeb(cost));
        int dp[][]=new int[cost.length][cost.length];

        for(int i=0;i<cost.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(MinCostMemo(cost,1,cost.length-1,dp));
    } 
    public static int MinCost(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=MinCost(arr,i,k);//Ai....Ak  => arr[i-1]*arr[k]
            int cost2=MinCost(arr,k+1,j);// Ak+1....Aj => arr[k]*arr[j]
            int cost3=arr[i-1]*arr[k]*arr[j];//(a*b*c)
            int finalcost= cost1+cost2+cost3;
            ans=Math.min(ans,finalcost);
        }
        return ans;
    }
    public static int MinCostMemo(int arr[],int i,int j,int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=MinCostMemo(arr,i,k,dp);//Ai....Ak  => arr[i-1]*arr[k]
            int cost2=MinCostMemo(arr,k+1,j,dp);// Ak+1....Aj => arr[k]*arr[j]
            int cost3=arr[i-1]*arr[k]*arr[j];//(a*b*c)
            int finalcost= cost1+cost2+cost3;
            ans=Math.min(ans,finalcost);
        }
        return dp[i][j]=ans;
    }
    public static int MinCostTeb(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        for(int len=2;len<n;len++){
            for(int i=1;i<=n-len;i++){
                int col=i+len-1;
                dp[i][col]=Integer.MAX_VALUE;
                for(int k=i;k<col;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][col];
                    int cost3=arr[i-1]*arr[k]*arr[col];
                    dp[i][col]=Math.min(dp[i][col],cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];

    }
}
