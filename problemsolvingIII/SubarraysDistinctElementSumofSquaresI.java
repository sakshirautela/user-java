package problemsolvingIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SubarraysDistinctElementSumofSquaresI {
    static void main() {
        System.out.println(sumCounts(new ArrayList<>(List.of(1,2,1))));
    }

    public int sumCounts2(List<Integer> nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] s = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            set.add(nums.get(i));
            s[i] = set.size();
        }
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int sum = s[j] - s[i];
                res += sum * sum;
            }
        }
        return res;
    }

    public static int sumCounts(List<Integer> nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.size();
        int[] st = new int[4 * n];
        buildSegmentTree(st, nums, set, 0, n - 1, 0);
        for (int i = 0; i < 4 * n; i++) {
            System.out.print(st[i] + " ");
        }
        System.out.println();
        return findSumCounts(st, 0, n, 0);
    }

    private static int findSumCounts(int[] st, int i, int j, int idx) {
        if (i == j) {
            return st[idx];
        }
        int mid = (i + j) / 2;
        return (st[idx] * st[idx]) + findSumCounts(st, i, mid, idx+1) + findSumCounts(st, mid + 1, j, idx+1);
    }

    private static int buildSegmentTree(int[] st, List<Integer> nums, HashSet<Integer> set, int i, int j, int idx) {
        if (i == j) {
            set.add(nums.get(i));
            return st[idx] = 1;
        }
        int mid = (i + j) / 2;
        return st[idx] = buildSegmentTree(st, nums, set, i, mid, idx + 1) + buildSegmentTree(st, nums, set, mid + 1, j, idx + 1);
    }
}
