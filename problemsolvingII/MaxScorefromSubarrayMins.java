public class MaxScorefromSubarrayMins {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] {}));
    }

    public static int maxSum(int arr[]) {
        // code here
        int n = arr.length;
        int result = arr[0] + arr[1];
        for (int i = 2; i < n; i++) {
            result = Math.max(result, arr[i] + arr[i - 1]);
        }
        return result;
    }
}