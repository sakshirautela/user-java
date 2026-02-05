public class a2 {
    static void main() {
        System.out.println(minimumK(new int[]{1,2,3,4,5}));
    }
    public static int minimumK(int[] nums) {
        int left = 1;
        int right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += (x + mid - 1) / mid;
            }

            if (ops <= (long) mid * mid) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
