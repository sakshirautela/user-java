
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(equalPartition(new int[] { 1, 3, 5, 3 }));
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0)
            return false;
        return partition(arr, sum / 2, 0);
    }

    public static boolean partition(int[] arr, int sum, int n) {
        if (sum == 0)
            return true;
        if (n >= arr.length)
            return false;

        if (arr[n] > sum)
            return partition(arr, sum, n + 1);

        return partition(arr, sum - arr[n], n + 1) || partition(arr, sum, n + 1);
    }

    static boolean equalPartitionDP(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;

        sum = sum / 2;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // inclde or exclude
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
