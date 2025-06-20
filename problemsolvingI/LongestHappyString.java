
import java.util.*;

public class LongestHappyString {
    static class Data {
        int digit;
        char ch;

        public Data(int digit, char ch) {
            this.digit = digit;
            this.ch = ch;
        }
    }

    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Data> pq = new PriorityQueue<Data>((x, y) -> y.digit - x.digit);
        if (a > 0) {
            pq.add(new Data(a, 'a'));
        }
        if (b > 0) {
            pq.add(new Data(b, 'b'));
        }
        if (c > 0) {
            pq.add(new Data(c, 'c'));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Data curr = pq.remove();
            int digit = curr.digit;
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == curr.ch && sb.charAt(sb.length() - 2) == curr.ch) {
                if (pq.isEmpty())
                    break;
                Data temp = pq.remove();
                sb.append(temp.ch);
                if (temp.digit - 1 > 0) {
                    pq.add(new Data(temp.digit - 1, temp.ch));
                }
            } else {
                digit--;
                sb.append(curr.ch);
            }
            if (digit > 0) {
                pq.add(new Data(digit, curr.ch));
            }
        }
        return sb.toString();
    }

    public String longestDiverseString2(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;

        for (int i = 0; i < totalLength; i++) {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0)) {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;
            } else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0)
                    || (continuousC == 2 && b > 0)) {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0)
                    || (continuousA == 2 && c > 0)) {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(longestDiverseString(1, 1, 7));
    }
}
