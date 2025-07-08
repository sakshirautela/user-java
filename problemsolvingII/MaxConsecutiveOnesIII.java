public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[] { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 }, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int start = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[start] == 0) {
                    zero--;
                }
                start++;
            }
            result = Math.max(result, i - start+1);
        }
        return result;
    }
}