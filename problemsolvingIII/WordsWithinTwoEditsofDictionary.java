package problemsolvingIII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordsWithinTwoEditsofDictionary {
    static void main() {
        System.out.println(twoEditWords(new String[]{"word", "note", "ants", "wood"}, new String[]{"wood", "joke", "moat"}));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        HashSet<String> hs = new HashSet<String>();
        List<String>li=new ArrayList<>();
        for (String query : queries) {
            if(hs.contains(query)) {
                li.add(query);
            }
            else if (find(query, dictionary)) {//&& !hs.contains(query)) {
                hs.add(query);
                li.add(query);
            }
        }
        return li;
    }

    private static boolean find(String query, String[] dictionary) {
        for (String word : dictionary) {
            int count = 0;
            if (word.length() == query.length()) {
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != word.charAt(i)) {
                        count++;
                    }

                }
            }
            if (count <= 2) {
                return true;
            }
        }
        return false;
    }
}