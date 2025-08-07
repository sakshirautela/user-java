public class CountHillsAndValleysInArrays {
    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
    }

    public static int countHillValley(int[] nums) {
        int n = nums.length;
        int i = 0;
        int mid = 1;
        int j = 2;
        int result = 0;
        while (j < n) {
            while (mid < n && nums[i] == nums[mid]) mid++;
            if (mid >= n) break;
            j = mid + 1;
            while (j < n && nums[mid] == nums[j]) j++;
            if (j >= n) break;
            if ((nums[mid] > nums[i] && nums[mid] > nums[j]) ||
                    (nums[mid] < nums[i] && nums[mid] < nums[j])) {
                result++;
            }

            i = mid;
            mid = j;
            j++;
        }

        return result;
    }

    public int countHillValleyFast(int[] nums) {
        int c = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;
            int val = nums[i];
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && val == nums[left]) {
                left--;
            }
            while (right < nums.length && val == nums[right]) {
                right++;
            }

            if (left >= 0 && right < nums.length) {
                if (val > nums[left] && val > nums[right]) {
                    c++;
                } else if (val < nums[left] && val < nums[right]) {
                    c++;
                }
            }
        }
        return c;
    }
}
