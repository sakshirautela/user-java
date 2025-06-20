public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {}, 7));
    }

    public static long countSubarrays(int[] nums, int k) {
        long result = 0l;
        int n = nums.length;
        int max = -1;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int j = 0;
        int freq = 0;
        for (int i = 0; i < n; i++) {
            if (max == nums[i]) {
                freq++;
            }
            while (freq >= k) {
                if (nums[j] == max) {
                    freq--;
                }
                j++;
            }
            result += j;
        }
        return result;
    }

    public long countSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        // Step 1: Find the maximum element
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int i = 0;
        int countmax = 0;
        long result = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] == max) {
                countmax++;
            }

            while (countmax >= k) {
                result += (n - j);
                if (nums[i] == max) {
                    countmax--;
                }
                i++;
            }
        }

        return result;
    }
}