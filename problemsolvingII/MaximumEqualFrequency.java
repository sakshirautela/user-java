public class MaximumEqualFrequency {
    static void main() {
        System.out.println(maxEqualFreq(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static int maxEqualFreq(int[] nums) {
        int n = nums.length;
        int result = 0;
        int max = 0;
        int prev = -1;
        boolean removed = false;
        int freq = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                freq++;
            } else {
                if (prev == -1) {
                    prev = freq;
                }
                if (!removed) {
                    removed = true;
                    freq = 0;
                }
            }
        }
        return freq;
    }
}