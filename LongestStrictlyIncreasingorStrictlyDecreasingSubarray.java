public class LongestStrictlyIncreasingorStrictlyDecreasingSubarray {
    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[] { 1, 2, 3 }));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int dec = 1;
        int inc = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                result = Math.max(result, inc);
                dec = 1;

            } else if (nums[i] < nums[i - 1]) {
                dec++;
                result = Math.max(result, dec);
                inc = 1;
            } else {
                result = Math.max(result, inc);
                result = Math.max(result, dec);
                dec = 1;
                inc = 1;
            }
        }
        return result;
    }

    public int longestMonotonicSubarray2(int[] nums) {
        int incLength = 1;
        int decLength = 1;
        int maxLength = 1;

        for (int pos = 0; pos < nums.length - 1; pos++) {
            if (nums[pos + 1] > nums[pos]) {
                incLength++;
                decLength = 1;
            } else if (nums[pos + 1] < nums[pos]) {
                decLength++;
                incLength = 1;
            } else {
                incLength = 1;
                decLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }
        return maxLength;
    }

}