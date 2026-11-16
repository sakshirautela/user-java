package problemsolvingIII;

public class ClimbingStairsII {
    static void main() {
        System.out.println(climbStairs(4,new int[]{}));
    }
    public static int climbStairs(int n, int[] costs) {
        int[] dp=new int[n];
        dp[1]=costs[1]-1;
        dp[2]=costs[2]-1;
        dp[3]=costs[3]-(2*2);
        for(int i=3;i<n;i++){
            dp[i]=Math.min(dp[i−1]+1,Math.min( dp[i−2]+4, dp[i−3]+9))+costs[i];

        }
    }
}
