public class CountofRangeSum {
    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[] {}, 2, 3));
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return mergeSortAndCount(prefixSum, 0, prefixSum.length - 1, lower, upper);
    }

    private static int mergeSortAndCount(long[] prefixSum, int left, int right, int lower, int upper) {
        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSortAndCount(prefixSum, left, mid, lower, upper) +
                mergeSortAndCount(prefixSum, mid + 1, right, lower, upper);

        int i = left, j1 = mid + 1, j2 = mid + 1;
        while (i <= mid) {
            while (j1 <= right && prefixSum[j1] - prefixSum[i] < lower)
                j1++;
            while (j2 <= right && prefixSum[j2] - prefixSum[i] <= upper)
                j2++;
            count += (j2 - j1); // Count valid indices
            i++;
        }

        merge(prefixSum, left, mid, right);
        return count;
    }

    private static void merge(long[] prefixSum, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (prefixSum[i] <= prefixSum[j]) {
                temp[k++] = prefixSum[i++];
            } else {
                temp[k++] = prefixSum[j++];
            }
        }

        while (i <= mid)
            temp[k++] = prefixSum[i++];
        while (j <= right)
            temp[k++] = prefixSum[j++];

        System.arraycopy(temp, 0, prefixSum, left, temp.length);
    }

    int lower, upper;

    public int countRangeSum2(int[] nums, int lower, int upper) {

        int n = nums.length;
        long prefixSum[] = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        long[] temp = new long[n + 1];
        this.lower = lower;
        this.upper = upper;

        return count(prefixSum, temp, 0, n);
    }

    public int count(long sum[], long temp[], int low, int high) {
        if (low >= high)
            return 0;

        int mid = high + low >> 1;

        int count = count(sum, temp, low, mid) + count(sum, temp, mid + 1, high);
        int index = 0;
        for (int i = low, j = mid + 1, k = mid + 1, l = mid + 1; i <= mid; i++) {
            long s = sum[i];
            while (j <= high && sum[j] - s < lower)
                j++;
            while (k <= high && sum[k] - s <= upper)
                k++;
            while (l <= high && sum[l] <= s)
                temp[index++] = sum[l++];
            temp[index++] = s;
            count += k - j;
        }

        System.arraycopy(temp, 0, sum, low, index);
        return count;
    }
}
