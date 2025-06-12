public class FindtheLexicographicallyLargestStringFromtheBoxI {
    public static void main(String[] args) {
        System.out.println(answerString("dbac", 2));
    }
    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }

    public String answerString2(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String last = lastSubstring(word);
        int n = word.length(), m = last.length();
        return last.substring(0, Math.min(m, n - numFriends + 1));
    }
    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String str = "";
        int n = word.length();
        for (int i = 0; i < n; i++) {
            String sub = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (sub.compareTo(str) > 0) {
                str = sub;
            }
        }
        return str;
    }
}