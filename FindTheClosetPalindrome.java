import java.util.ArrayList;
import java.util.List;

public class FindTheClosetPalindrome {
    // Time Limit exceed
    public static String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        for (int i = 1; i < num; i++) {
            String s = Long.toString(num + i);
            String s2 = Long.toString(num - i);
            if (isPlaindrom(s2)) {
                return s2;
            }
            if (isPlaindrom(s)) {
                return s;
            }
        }
        return n;
    }

    public static boolean isPlaindrom(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String nearestPalindromic2(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        if (len == 1) {
            return Long.toString(num - 1);
        }

        List<Long> candidates = new ArrayList<>();
        candidates.add((long) Math.pow(10, len) + 1); // For cases like 1000 -> 1001
        candidates.add((long) Math.pow(10, len - 1) - 1); // For cases like 1000 -> 999

        String prefix = n.substring(0, (len + 1) / 2);
        long prefixNum = Long.parseLong(prefix);

        candidates.add(isPlaindrom(prefixNum, len % 2 == 0)); // Same prefix
        candidates.add(isPlaindrom(prefixNum + 1, len % 2 == 0)); // Prefix + 1
        candidates.add(isPlaindrom(prefixNum - 1, len % 2 == 0)); // Prefix - 1

        long closest = Long.MAX_VALUE;
        long minDiff = Long.MAX_VALUE;

        for (long candidate : candidates) {
            if (candidate == num) {
                continue;
            }
            long diff = Math.abs(candidate - num);
            if (diff < minDiff || (diff == minDiff && candidate < closest)) {
                minDiff = diff;
                closest = candidate;
            }
        }

        return Long.toString(closest);
    }
    private static Long isPlaindrom(long s, boolean even) {
        long res = s;
        System.out.println(res);
        if (!even) {
            s /= 10;
        }
        while (s > 0) {
            res = res * 10 + s % 10;
            s /= 10;
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(nearestPalindromic2("999"));
    }
}
