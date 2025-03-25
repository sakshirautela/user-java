public class MaximumAbsoluteSumofAnySubarray {
    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum2(new int[] { 1, -3, 2, 3, -4 }));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int maxSum = 0;
        for (int i : nums) {
            if (sum < 0) {
                sum = i;
            } else {
                sum += i;
            }
            maxSum = Math.max(maxSum, sum);
        }
        sum = 0;
        for (int i : nums) {
            if (sum > 0) {
                sum = i;
            } else {
                sum += i;
            }
            maxSum = Math.max(maxSum, Math.abs(sum));
        }
        return maxSum;
    }

    public static int maxAbsoluteSum2(int[] a) {
        int n = a.length;
        int s = a[0];
        int min = 0, max = 0;
        if (a[0] < min)
            min = a[0];
        if (a[0] > max)
            max = a[0];
        for (int i = 1; i < n; i++) {
            s = s + a[i];
            if (s > max)
                max = s;
            if (s < min)
                min = s;
        }

        return Math.abs(max - min);
    }
    
}