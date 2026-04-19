package problemsolvingIII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumValueofConcatenatedBinarySegments {
    static void main() {
        System.out.println(maxValue(new int[]{1, 2}, new int[]{1, 0}));
    }

    public static int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        StringBuilder[] sb = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            StringBuilder num = new StringBuilder();
            int o = nums1[i];
            int z = nums0[i];
            while (o > 0) {
                num.append('1');
                o--;
            }
            while (z > 0) {
                num.append('0');
                z--;
            }
            idx[i] = i;
            sb[i] = num;
        }
        int res = 0;
        Arrays.sort(idx, (a, b) -> Integer.compare(nums1[b], nums1[a]));
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(sb[idx[i]]);
        }
        return Integer.parseInt(s.toString(),2);
    }
}
