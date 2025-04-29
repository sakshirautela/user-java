
import java.util.HashMap;

public class MinimumOperationstoMakeArrayValuesEqualtoK {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {}, 5));
    }

    public static int minOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            if (i > k) {
                hm.put(i, hm.getOrDefault(i, 0) + 1);
            }
            if (i < k) {
                return -1;
            }
        }

        return hm.size();
    }

    public int minOperations2(int[] nums, int k) {
        boolean[] has = new boolean[101];

        for (int num : nums) {
            has[num] = true;
        }
        int cnt = 0;
        for (int i = 0; i < has.length; i++) {
            if (!has[i])
                continue;

            if (has[i] && i < k)
                return -1;
            else if (has[i] && i > k)
                cnt++;
        }
        return cnt;
    }
}
