
public class NumberofWaystoSplitArray {
    public static void main(String args[]) {
        System.out.println(waysToSplitArray(new int[] {}));
    }

    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            long left = prefixSum[i];
            long right = prefixSum[n - 1] - prefixSum[i];
            if (left >= right) {
                res++;
            }
        }
        return res;
    }

    public int waysToSplitArray2(int[] nums) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int i = 0;
        int cnt = 0;
        long n = 0;
        while (i < nums.length - 1) {
            n += nums[i];
            long r = sum - n;

            if (n >= r) {
                cnt++;
            }
            i++;
        }
        return cnt;
    }
}
