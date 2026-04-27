package problemsolvingIII;

import java.util.ArrayList;
import java.util.List;

public class MinimumOperationstoMakeAllArrayElementsEqual {
    static void main() {
        minOperationsTLE(new int[]{}, new int[]{});
    }
    public static List<Long> minOperationsTLE(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();
        for (int q : queries) {
            long diff = 0;
            for (int num : nums) {
                diff += Math.abs(num - q);
            }
            res.add(diff);
        }
        return res;
    }
}