import java.util.ArrayList;
import java.util.List;

public class TransformArraytoAllEqualElements {
    public static void main(String[] args) {
        System.out.println(canMakeEqual(new int[] {}, 2));
    }

    public static boolean canMakeEqual(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return true;
        
        int prod = 1;
        for (int x : nums) prod *= x;

        List<Integer> targets = new ArrayList<>();
        for (int target : new int[]{1, -1}) {
            int tPowN = (n % 2 == 0 ? 1 : target);
            if (tPowN == prod) targets.add(target);
        }

        if (targets.isEmpty()) return false;

        for (int target : targets) {
            int ops = 0;
            int[] a = nums.clone();
            for (int i = 0; i < n - 1 && ops <= k; i++) {
                if (a[i] != target) {
                    a[i] = -a[i];
                    a[i + 1] = -a[i + 1];
                    ops++;
                }
            }
            
            if (ops <= k && a[n - 1] == target) {
                return true;
            }
        }

        return false;
    }
    public boolean canMakeEqual2(int[] nums, int k) {
         return tryMakeAll(nums, k, 1) || tryMakeAll(nums, k, -1);
    }

    public boolean tryMakeAll(int[] nums, int k, int target) {
        int operations = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != target) {
                nums[i] *= -1;
                nums[i + 1] *= -1;
                operations++;
                if (operations > k) return false;
            }
        }
        return nums[nums.length - 1] == target;
    }
}