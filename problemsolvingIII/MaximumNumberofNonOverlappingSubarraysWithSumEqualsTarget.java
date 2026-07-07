package problemsolvingIII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget {
    static void main() {
        System.out.println(maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
    }

    public int maxNonOverlappingFast(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - target)) {
                ans++;
                sum = 0;
                set.clear();
                set.add(0);
            } else {
                set.add(sum);
            }
        }
        return ans;
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prev = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                int idx = map.get(sum - target);
                if (idx > prev) {
                    prev = i;
                    res++;
                }
            }
            map.put(sum, i);
        }
        return res;
    }
}
