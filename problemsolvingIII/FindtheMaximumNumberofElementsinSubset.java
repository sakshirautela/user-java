package problemsolvingIII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class FindtheMaximumNumberofElementsinSubset {
    static void main() {
        System.out.println(maximumLength(new int[]{4, 36, 9, 16, 1, 1, 4, 121, 64, 4}));
    }

    public static int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        int ones = 0;
        for (int i : nums) {
            if (i == 1) {
                ones++;
            } else {
                map.put((long) i, map.getOrDefault((long) i, 0) + 1);
            }
        }
        int ans = 1;
        for (Long start : map.keySet()) {
            long key = start;
            int count = 0;
            while (map.getOrDefault(key, 0) >= 2) {
                count += 2;
                if (key > Integer.MAX_VALUE) {
                    break;
                }
                key *= key;
            }
            if (map.containsKey(key)) {
                count++;
            } else if (count > 0) {
                count--;
            }
            ans = Math.max(ans, count);
        }
        if (ones > 0) {
            ans = Math.max(ans, (ones % 2 == 1) ? ones : ones - 1);
        }
        return ans;
    }

    private static int ifStartWith(int key, HashSet<Integer> one, HashSet<Integer> two) {
        int count = 0;
        while (two.contains(key)) {
            count += 2;
            key *= key;
        }
        if (one.contains(key)) {
            return count += 1;
        } else {
            return count - 1;
        }
    }
}
