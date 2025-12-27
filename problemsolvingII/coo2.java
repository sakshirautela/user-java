import java.util.*;

public class coo2 {
    public static void main(String[] args) {
        System.out.println(score(new String[]{"cb", "ca", "cc" }, 'c')); // 0
    }

    public static int score(String[] cards, char x) {
        Map<Integer, Integer> f = new HashMap<>();
        Map<Integer, Integer> s = new HashMap<>();
        int xx = 0;
        HashSet<String> hs = new HashSet<>();
        for (String c : cards) {
            if (hs.contains(c)) {
                continue;
            }
            hs.add(c);
            if (c.charAt(0) == x && c.charAt(1) == x) {
                xx++;
            } else if (c.charAt(0) == x) {
                f.put(0, f.getOrDefault(0, 0) + 1);
            } else if (c.charAt(1) == x) {
                s.put(1, s.getOrDefault(1, 0) + 1);
            }
        }
        int points = 0;
        for (int i = 0; i < 2; i++) {
            int a = (f.getOrDefault(i, 0)) / 2;
            points += a;
            f.put(i, f.getOrDefault(i, 0) - a*2);
            if (f.get(i) <= 0) {
                f.remove(i);
            }
            a = (s.getOrDefault(i, 0)) / 2;
            points += a;
            s.put(i, s.getOrDefault(i, 0) - a*2);
            if (s.get(i) <= 0) {
                s.remove(i);
            }
        }
        xx %= 2;
        if (xx == 1) {
            int a = f.getOrDefault(0, 0) >= 1 ? 1 : 0;
            if (a > 0) {
                return points + 1;
            }
            a = f.getOrDefault(1, 0) >= 1 ? 1 : 0;
            if (a > 0) {
                return points + 1;
            }
            a = s.getOrDefault(0, 0) >= 1 ? 1 : 0;
            if (a > 0) {
                return points + 1;
            }
            a = s.getOrDefault(1, 0) >= 1 ? 1 : 0;
            if (a > 0) {
                return points + 1;
            }
        }

        return points;
    }
}
