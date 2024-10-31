import java.util.Arrays;
import java.util.HashSet;

public class ExtraCharactersinaString {
    public static void main(String[] args) {
        System.out.println(minExtraChar("dwmodizxvvbosxxw",
                new String[] { "ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz",
                        "ds", "kzbu" }));
    }

    public static int minExtraCharWrongByMe(String s, String[] dictionary) {
        int n = dictionary.length;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < n; i++) {
            int idx = s.indexOf(dictionary[i]);
            System.out.println(idx);
            if (idx != -1) {
                Arrays.fill(dp, idx, idx + dictionary[i].length(), true);
            }
        }
        int result = 0;
        for (boolean i : dp) {
            if (!i) {
                result++;
            }
        }
        return result;
    }

    static class Node {
        public Node[] child;
        public boolean isEnd;

        public Node() {
            child = new Node[26];
            isEnd = false;
        }
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Node root = new Node();
        for (String str : dictionary) {
            insert(str, root);
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            search(s, root, i, dp);
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }
        return dp[n];
    }

    public static void insert(String s, Node root) {
        for (int i = 0; i < s.length(); i++) {
            int path = s.charAt(i) - 'a';
            if (root.child[path] == null) {
                Node node = new Node();
                root.child[path] = node;
            }
            root = root.child[path];
        }
        root.isEnd = true;
    }

    public static void search(String s, Node root, int idx, int[] dp) {
        for (int i = idx; i < s.length(); i++) {
            int path = s.charAt(i) - 'a';
            if (root.child[path] != null) {
                root = root.child[path];
                if (root.isEnd) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[idx]);
                }
            } else {
                return;
            }
        }
    }

    public int minExtraCharDP(String s, String[] dictionary) {

        int n = s.length();
        var dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        var dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                var curr = s.substring(start, end + 1);
                if (dictionarySet.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }
}