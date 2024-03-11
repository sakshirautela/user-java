class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        if (s == target) {
            return nums.length;
        }
        while (right < nums.length) {
            sum += nums[right];
            while (sum > target) {
                sum = sum - nums[left];
                result = Math.min(result, right - left + 1);
                left++;
            }
            right++;
        }
        return result != Integer.MAX_VALUE ? result : 0;
    }

    public static void main(String[] args) {
        int[] array = { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 };
        System.out.println(minSubArrayLen(15, array));
    }
}