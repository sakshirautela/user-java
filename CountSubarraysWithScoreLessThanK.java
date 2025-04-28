public class CountSubarraysWithScoreLessThanK {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] { 1, 1, 1 }, 5));
    }

    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long res = 0, total = 0;
        for (int i = 0, j = 0; j < n; j++) {
            total += nums[j];
            while (i <= j && total * (j - i + 1) >= k) {
                total -= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public long countSubarrays2(int[] nums, long k) {

        long total = 0;
        long count = 0;
        for (int start = 0, end = 0; end < nums.length; end++) {

            total += nums[end];

            while (start <= end && total * (end - start + 1) >= k) {
                total -= nums[start];
                start++;
            }
            count += end - start + 1;

        }
        return count;

    }
}