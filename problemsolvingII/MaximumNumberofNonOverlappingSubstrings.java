import java.util.*;

public class MaximumNumberofNonOverlappingSubstrings {
    public static void main(String[] args) {
        System.out.println(maxNumOfSubstrings("abbaccd"));
    }

    public static List<String> maxNumOfSubstrings(String s) {
        List<String> li = new ArrayList<>();
        int[][] valididx = new int[26][2];
        int len = 0;
        for (int i = 0; i < 26; i++) {
            valididx[i][0] = -1;
            valididx[i][1] = -1;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (valididx[ch - 'a'][0] == -1) {
                valididx[ch - 'a'][0] = i;
            }
            valididx[ch - 'a'][1] = i;
        }
        ArrayList<int[]> inter = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (valididx[i][0] == -1) {
                continue;
            }
            int l = valididx[i][0], r = valididx[i][1];
            boolean valid = true;
            for (int j = l; j <= r; j++) {
                char ch = s.charAt(j);
                if (valididx[ch - 'a'][0] < l) {
                    valid = false;
                }
                r = Math.max(r, valididx[ch - 'a'][1]);
            }
            if (valid) {
                inter.add(new int[]{l, r});
            }
        }
        Collections.sort(inter, (a, b) -> a[1] - b[1]);
        int prev = -1;
        for (int i = 0; i < inter.size(); i++) {
            if (prev < inter.get(i)[0]) {
                li.add(s.substring(inter.get(i)[0], inter.get(i)[1] + 1));
                prev = inter.get(i)[1];
            }
        }
        return li;

    }

    public List<String> maxNumOfSubstrings2(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        // 1. Find first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // 2. Build candidate intervals
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) continue;
            int start = first[c];
            int end = last[c];
            boolean valid = true;

            // Expand range until it includes all chars fully
            for (int i = start; i <= end && valid; i++) {
                int ch = s.charAt(i) - 'a';
                if (first[ch] < start) {
                    valid = false; // Not valid, overlaps outside
                    break;
                }
                end = Math.max(end, last[ch]);
            }
            if (valid) intervals.add(new int[]{start, end});
        }

        // 3. Sort by end (greedy interval scheduling)
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> res = new ArrayList<>();
        int prevEnd = -1;
        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) { // non-overlapping
                res.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }

        return res;
    }
}
