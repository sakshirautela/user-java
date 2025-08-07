import java.util.Arrays;
import java.util.List;

public class LengthoftheLongestSubsequenceThatSumstoTarget {
    public static void main(String[] args) {
        System.out.println(new LengthoftheLongestSubsequenceThatSumstoTarget()
                .lengthOfLongestSubsequence(List.of(1, 2, 3, 4, 5), 9));
    }
    
    public int lengthOfLongestSubsequenceUndersrand(List<Integer> nums, int target) {
        int dp[]= new int[target+1];
        
        for(int i=1;i<=target;i++){
            dp[i]=-1;
        }
        for(int num:nums){
            for(int j=target;j>=num;j--){
                if(dp[j-num]!=-1){
                    dp[j]=Math.max(dp[j],dp[j-num]+1);
                }
            }
        }
        return dp[target];
    }
   public int lengthOfLongestSubsequenceFast(List<Integer> nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++){
            int n = nums.get(i);
            sum+=n;
            for (int c = Math.min(sum, target); c >= n; c--){
                dp[c] = Math.max(dp[c], dp[c-n]+1);
            }
        }
        return dp[target] >= 0? dp[target] : -1;
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
         int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for(int i=0;i<=n;i++) {
            dp[i][0] = 0; 
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=nums.get(i-1)&& dp[i-1][j-nums.get(i-1)] != -1) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-nums.get(i-1)]+1);
                }
            }
        }
        print(dp);
        return dp[n][target];
    }
    private void print(int[][] dp) {
        for (int[] row : dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}