public class MaximumSumofElementsNotPartofLIS {
    public static void main(String[] args) {
        System.out.println(new MaximumSumofElementsNotPartofLIS().nonLisMaxSum(new int[] { 4, 6, 1, 2, 3, 8 }));
    }

    public int nonLisMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        int minsum = Integer.MAX_VALUE;
        int len = 1;
        int maxlen = 1;
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1] + arr[i];
            if (arr[i] >= arr[i - 1]) {
                len++;
            } else {
                if (len > maxlen) {
                    maxlen = len;
                    minsum = sum[i - 1] - (i - len - 1 < 0 ? 0 : sum[i - len]);
                    len = 1;
                } else if (len == maxlen) {
                    minsum = Math.min(minsum, sum[i - 1] - (i - len - 1 < 0 ? 0 : sum[i - len]));
                    len = 1;
                }
            }

        }
        if (len == n) {
            return 0;
        }
        if (len > maxlen) {
            minsum = sum[n - 1] - (n - len-1 < 0 ? 0 : sum[n - len-1]);
        } else if (len == maxlen) {
            minsum = Math.min(minsum, sum[n - 1] - (n-len-1<0 ?0:sum[n - len-1]));
        }
        return sum[n - 1] - minsum;
    }
}