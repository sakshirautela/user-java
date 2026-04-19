package problemsolvingIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ClosestEqualElementQueries {
    static void main() {
        System.out.println(solveQueriesCorrect(new int[]{15, 1, 10, 1, 20, 4, 6, 14, 4, 9, 4, 18}, new int[]{0, 2, 10, 6, 11, 8}));
    }

    public static List<Integer> solveQueriesCorrect(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.putIfAbsent(nums[i], new ArrayList<>());
            freq.get(nums[i]).add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (freq.containsKey(nums[queries[i]]) && !freq.get(nums[queries[i]]).isEmpty()) {
                list.add(searchAbsMinDistance(freq.get(nums[queries[i]]), queries[i], n));
            } else {
                list.add(-1);
            }
        }
        return list;
    }

    private static int searchAbsMinDistance(List<Integer> li, int query, int n) {
        int i = 0;
        int j = li.size() - 1;
        int res = Integer.MAX_VALUE;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (li.get(mid) != query) {
                int diff = Math.abs(li.get(mid) - query);
                int circularDist = Math.min(diff, n - diff);
                res = Math.min(res, circularDist);
            }
            if (li.get(mid) <= query) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return res==Integer.MAX_VALUE?-1:res;
    }

    //cant able to handle elemnts with same frequency;
    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int q : queries) {
            map.put(nums[q], q);
        }
        int n = nums.length;
        HashMap<Integer, Integer> min = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = Integer.MAX_VALUE;
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                r = Math.min(Math.abs(i - map.get(nums[i])), r);
                r = Math.min(Math.abs(n - map.get(nums[i]) + i), r);
                if (min.containsKey(map.get(nums[i]))) {
                    map.put(map.get(nums[i]), Math.min(min.get(map.get(nums[i])), r));
                } else {
                    min.put(map.get(nums[i]), r);
                }
            }
        }
        for (int q : queries) {
            ans.add(min.getOrDefault(q, -1));
        }
        System.out.println(min);
        return ans;
    }
}