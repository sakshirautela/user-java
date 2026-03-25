public class MinimumElementAfterReplacementWithDigitSum {
    static void main() {
        System.out.println(minElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int n = 0;
            while (num != 0) {

                n += num % 10;
                num /= 10;
            }
            if (n < min) {
                min = n;
            }
        }
        return min;
    }
}