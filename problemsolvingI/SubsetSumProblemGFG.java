
public class SubsetSumProblemGFG {
    public static void main(String[] args) {
        System.out.println(isSubsetSum(new int[]{},4));
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true; // Base case: subset sum 0 is always possible

        for (int num : arr) {
            for (int j = sum; j >= num; j--) { // Iterate backwards to avoid overwriting
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}
