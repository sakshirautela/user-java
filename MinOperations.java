public class MinOperations {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int c = nums[n - 1] == 1 ? 1 : 0;
        int h = 0, a = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 1) {
                c++;
            }
            if (gcd(nums[i], nums[i + 1]) == 1) {
                h++;
            }
        }
        if (c + h > 0) {
            return n - c;
        }
        for (int i = 0; i < n - 1; i++) {
            int b = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (gcd(b, nums[j]) == 1) {
                    a = Math.min(a, j - i + n - 1);
                    break;
                }
                b = gcd(b, nums[j]);
            }
        }
        return a == Integer.MAX_VALUE ? -1 : a;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        
    }
}
