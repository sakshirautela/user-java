package Contest;

import java.util.ArrayList;
import java.util.Arrays;

public class BiweeklyContest184 {
    static void main() {
//        System.out.println(consecutiveSetBits(30));
        System.out.println(minEnergy(2, 1, new int[][]{{0, 0}, {2, 2}}));
//        ArrayList<int[]> li = merge(new int[][]{
//                {1, 3},
//                {1, 6},
//                {3, 10},
//                {15, 18}
//        });
//        for (int[] i : li) {
//            System.out.println(i[0] + " " + i[1]);
//        }
//        System.out.println(maxTotal(new int[]{9, 2, 6, 1}, "0111"));
    }


    public static boolean consecutiveSetBits(int n) {
        int count = 0;
        int c = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                c++;
            } else {
                if (c == 2) {
                    count++;
                } else if (c > 2) {
                    return false;
                }
                c = 0;
            }
            n >>= 1;
        }
        if (c == 2) {
            count++;
        } else if (c > 0) {
            return false;
        }
        return count == 1;
    }

    public static long minEnergy(int n, int brightness, int[][] intervals) {
        long total = 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int energy = brightness / 3 + ((brightness % 3 != 0) ? 1 : 0);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int s=intervals[i][0];
            int e=intervals[i][1];
            if(end>=s){
                start = Math.min(start, s);
                end = Math.max(end, e);
            }else{
                total+=(end-start+1);
                start=s;
                end=e;
            }
        }
        total += (end-start+1);
        return total*energy;
    }

    public static ArrayList<int[]> merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] pre = res.getLast();
            int[] curr = interval;
            if (pre[1] >= interval[0]) {
                curr[0] = Math.min(pre[0], interval[0]);
                curr[1] = Math.max(pre[1], interval[1]);
                res.removeLast();
            }
            res.add(curr);
        }
        return res;
    }

    public static long maxTotal(int[] nums, String s) {
        int n = s.length();
        long res = 0;
        long min = Long.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (i < n - 1 && s.charAt(i + 1) == '1') {
                    res += nums[i + 1];
                    min = Math.min(min, nums[i]);
                    res -= min;
                }
                min = Integer.MAX_VALUE;
            } else {
                res += nums[i];
                min = Math.min(min, nums[i]);
            }
        }
        return res;
    }
        public long maxTotalFastets(int[] nums, String s) {
            char[] cs = s.toCharArray();
            int n = cs.length;
            long sum = 0;
            int min = 0;
            for(int i = 0; i < n; ++i){
                int x = nums[i];
                if(cs[i] == '0'){
                    min = x;
                }else{
                    sum += Math.max(x, min);
                    min = Math.min(min, x);
                }
            }
            return sum;
        }

    public static long maxTotalTLE(int[] nums, String s) {
        int len = s.length();
//        for (int i = 1; i < len; i++) {
//            if (s.charAt(i) == '1') {
//                if (s.charAt(i - 1) == '1') {
//                    ans += nums[i];
//                } else {
//                    ans += Math.max(nums[i - 1], nums[i]);
//                }
//            }
//        }
        char[] chars = s.toCharArray();
        return maxTotalHelper(nums, chars, 0, len);
    }

    private static long maxTotalHelper(int[] nums, char[] chars, int i, int len) {
        if (i == len) {
            return 0;
        }
        long a = 0;
        if (i > 0 && chars[i] == '1' && chars[i - 1] == '0') {
            a = nums[i - 1];
            chars[i - 1] = 1;
            chars[i] = '0';
            a += maxTotalHelper(nums, chars, i + 1, len);
            chars[i] = '1';
            chars[i - 1] = '0';

        }
        long b = chars[i] == '1' ? nums[i] : 0;
        b += maxTotalHelper(nums, chars, i + 1, len);
        return Math.max(a, b);
    }

}