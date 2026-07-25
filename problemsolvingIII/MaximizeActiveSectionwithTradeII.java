package problemsolvingIII;

import java.util.ArrayList;
import java.util.List;

public class MaximizeActiveSectionwithTradeII {
    static void main() {

//        System.out.println(maxActiveSectionsAfterTrade("0100", new int[][]{{2, 3}}));
    }

//    public static List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
//        List<Integer> start = new ArrayList<>();
//        List<Integer> end = new ArrayList<>();
//        List<Integer> count = new ArrayList<>();
//
//        int n = s.length();
//        int ones = 0;
//
//        // Count total active sections (1s)
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) == '1') {
//                ones++;
//            }
//        }
//
//        // Build zero blocks
//        int c = 0;
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) == '0') {
//                if (c == 0) {
//                    start.add(i);
//                }
//                c++;
//            } else {
//                if (c != 0) {
//                    count.add(c);
//                    end.add(i - 1);
//                    c = 0;
//                }
//            }
//        }
//        if (c != 0) {
//            count.add(c);
//            end.add(n - 1);
//        }
//
//        int m = count.size();
//
//        List<Integer> ans = new ArrayList<>();
//
//        // If fewer than two zero blocks, no improvement is possible
//        if (m < 2) {
//            for (int i = 0; i < queries.length; i++) {
//                ans.add(ones);
//            }
//            return ans;
//        }
//
//        // Build sparse table array
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < m - 1; i++) {
//            temp.add(count.get(i) + count.get(i + 1));
//        }
//
//        SparseTable st = new SparseTable(temp);
//
//        for (int[] q : queries) {
//            int l = q[0];
//            int r = q[1];
//
//            int idx = lowerBound(end, l);
//            int jdx = upperBound(start, r) - 1;
//
//            if (idx >= m || jdx < 0 || idx >= jdx) {
//                ans.add(ones);
//                continue;
//            }
//
//            int firstLen = end.get(idx) - Math.max(start.get(idx), l) + 1;
//            int lastLen = Math.min(end.get(jdx), r) - start.get(jdx) + 1;
//
//            if (idx + 1 == jdx) {
//                ans.add(ones + firstLen + lastLen);
//                continue;
//            }
//
//            int val1 = firstLen + count.get(idx + 1);
//            int val2 = count.get(jdx - 1) + lastLen;
//            int val3 = st.query(idx + 1, jdx - 2);
//
//            int bestGain = Math.max(val1, Math.max(val2, val3));
//            ans.add(ones + bestGain);
//        }
//
//        return ans;
//    }
//    private int lowerBound(List<Integer> list, int target) {
//        int left = 0,
//                right = list.size();
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (list.get(mid) < target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
//    }
//
//    private int upperBound(List<Integer> list, int target) {
//        int left = 0,
//                right = list.size();
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (list.get(mid) <= target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
//    }
//    public static List<Integer> maxActiveSectionsAfterTradeTLE(String s, int[][] queries) {
//        List<Integer> li = new ArrayList<>();
//        int n = s.length();
//        int[] pre = new int[n];
//        pre[0] = s.charAt(0) == '0' ? 0 : 1;
//        for (int i = 1; i < n; i++) {
//            if (s.charAt(i) == '1') {
//                pre[i] = pre[i - 1] + 1;
//            } else {
//                pre[i] = pre[i - 1];
//            }
//        }
//        for (int[] q : queries) {
//            li.add(maxActiveSectionsAfterTradeON(s, q[0], q[1], pre, n));
//        }
//        return li;
//    }
//
//    public static int maxActiveSectionsAfterTradeON(String s, int a, int b, int[] pre, int n) {
//        int prev = 0, curr = 0, one = 0;
//        int max = 0;
//        for (int i = a; i <= b; i++) {
//            if (s.charAt(i) == '0') {
//                curr++;
//            } else {
//                if (curr != 0) {
//                    prev = curr;
//                    curr = 0;
//                }
//                one++;
//            }
//            max = Math.max(curr + prev, max);
//        }
//        int rem = pre[n - 1] - pre[b] + (a > 0 ? pre[a - 1] : 0);
//        if (max == curr || max == prev) { // checking is zero presented only one side
//            return one + rem;
//        }
//        return one + max + rem;
//    }
}