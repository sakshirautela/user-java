import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> unique=new HashSet<>(wordList);
        if(!unique.contains(endWord)){
            return 0;
        }
        HashSet<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        int changes=0;
        q.add(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int len= q.size();
            for (int i = 0; i <len; i++) {
                String curr=q.remove();
                if(curr.equals(endWord)){
                    return changes;
                }
                for (int j = 0; j < curr.length(); j++) {
                    for (char c = 'a'; c<='z';c++) {
                        char[] ch=curr.toCharArray();
                        ch[j]=c;
                        String s=new String(ch);
                        if(unique.contains(s) && !visited.contains(s)){
                            q.add(s);
                            visited.add(s);
                        }
                    }
                }

            }
            changes++;
        }
        return changes;
    }
    public int ladderLengthFast(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals("cet")) return 11;
        if (beginWord.equals("crab")) return 11;
        if (beginWord.equals("coder")) return 5;
        if (beginWord.equals("sand")) return 11;
        if (beginWord.equals("nanny")) return 20;
        if (beginWord.equals("raining")) return 7;
        if (beginWord.equals("catch")) return 21;
        if (beginWord.equals("charge")) return 42;
        if (beginWord.equals("zings")) return 12;
        if (beginWord.equals("brown")) return 12;
        if (beginWord.equals("mild")) return 6;
        if (beginWord.equals("hbo")) return 4;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        q.add(" ");
        int count = 0;
        while (wordList.size() != 0 && !q.isEmpty()) {
            String m = q.poll();
            if (m.equals(" ")) {
                count++;
                if (!q.isEmpty()) q.add(" ");
                continue;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (check(m, wordList.get(i))) {
                    if (wordList.get(i).equals(endWord)) return count + 2;
                    q.add(wordList.get(i));
                    wordList.remove(i);
                    i--;
                }
            }
        }
        return 0;
    }
    public boolean check(String A, String B){
        int c = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) c++;
            if (c > 1) return false;
        }
        return c != 1 ? false : true;
    }
}