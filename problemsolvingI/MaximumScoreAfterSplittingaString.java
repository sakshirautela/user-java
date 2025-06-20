
public class MaximumScoreAfterSplittingaString {
    public static void main(String args[]) {
        System.out.println(maxScore("011101"));
    }

    public static int maxScore(String s) {
        int totalones = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalones++;
            }
        }
        int res = 0;
        int zeros = 0;
        int one = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                zeros++;
            }
            res = Math.max(res, zeros + totalones - one);
        }
        return res;

    }

    public int maxScore2(String s) {
        int n = s.length();
        int ons = 0;
        int curr = s.charAt(0) == '0' ? 1 : 0;
        int score = curr;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                curr++;
            } else {
                ons++;
                curr--;
            }
            if (curr > score) {
                score = curr;
            }
        }
        ons += s.charAt(n - 1) == '1' ? 1 : 0;

        return ons + score;
    }
}
