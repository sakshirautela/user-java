import java.util.ArrayList;
import java.util.List;

public class MinimumAdjacentSwapstoAlternateParity {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[] { 2,4,6,5,7 }));
    }

    public static int minSwaps(int[] nums) {
         int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                pos.add(i);
            }
        }

        int m = pos.size();
        int o = n - m;
        if (Math.abs(m - o) > 1) return -1;

        return n % 2 == 0
                ? Math.min(calc(pos, n, true), calc(pos, n, false))
                : (m > o ? calc(pos, n, true) : calc(pos, n, false));
    }

    private static int calc(List<Integer> pos, int n, boolean startEven) {
        List<Integer> tgt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((startEven && i % 2 == 0) || (!startEven && i % 2 == 1)) {
                tgt.add(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < pos.size(); i++) {
            sum += Math.abs(pos.get(i) - tgt.get(i));
        }
        return sum;
    }
}