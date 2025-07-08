import java.util.HashSet;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {}));
    }


    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int val : nums) {
            hs.add(val);
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (!hs.contains(i)) {
                return n;
            }
        }
        return n + 1;
    }

    public int firstMissingPositiveFastWithRules(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > n || nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val > 0 && val <= n) {
                if (nums[val - 1] > 0)
                    nums[val - 1] = -nums[val - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}