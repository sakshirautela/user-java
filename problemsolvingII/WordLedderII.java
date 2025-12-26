import java.util.*;

public class WordLedderII {
    public static void main(String[] args) {
        System.out.println(findLadders("", "", new ArrayList<>()));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> unique = new HashSet<>(wordList);
        if (!unique.contains(endWord)) {
            return res;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int changes = 0;
        q.add(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String curr = q.remove();
                if (curr.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < curr.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] ch = curr.toCharArray();
                        ch[j] = c;
                        String s = new String(ch);
                        if (unique.contains(s) && !visited.contains(s)) {
                            q.add(s);
                            visited.add(s);
                        }
                    }
                }

            }
            changes++;
        }
        return res;
    }
}