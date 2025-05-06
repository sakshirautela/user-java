public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {}, 1, 5));
    }

    static {
        int[] arr1 = { 1, 3, 2, 5, 2, 7, 1 };
        int[] arr2 = { 1, 1, 1, 1, 1, 1, 1 };
        for (int i = 0; i < 100; i++) {
            countSubarrays(arr1, 2, 5);
            countSubarrays(arr2, 1, 1);
            countSubarrays(arr1, 2, 5);
        }
    }

    public static long countSubarrays2(int[] nums, int minK, int maxK) {
        long count = 0;
        int start = -1, mini = -1, maxi = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK)
                start = i;
            else {
                if (nums[i] == maxK)
                    maxi = i;
                if (nums[i] == minK)
                    mini = i;
                int valid = Math.max(0, Math.min(mini, maxi) - start);
                count += valid;
            }
        }
        return count;
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minidx = -1, maxidx = -1;
        int start = -1;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                start = i;
            }
            if (nums[i] == minK) {
                minidx = i;
            }
            if (nums[i] == maxK) {
                maxidx = i;
            }
            long include = Math.max(0, Math.min(minidx, maxidx) - start);
            res += include;
        }
        return res;
    }
}