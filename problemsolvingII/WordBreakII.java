import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(wordBreak("",new ArrayList<>()));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> li=new ArrayList<>();
        wordBreakUtill(li,wordDict,new StringBuilder(),s);
        return li;
    }
    private static void wordBreakUtill(List<String> li, List<String> wordDict, StringBuilder string, String s) {
        if(s.length()==0){
            li.add(string.toString().trim());
            return;
        }
        for(String curr:wordDict){
            int a=curr.length();
            if(a>s.length()){
                continue;
            }
            if(s.substring(0,a).equals(curr)){
                int len=string.length();
                wordBreakUtill(li, wordDict, string.append(" "+curr), s.substring(a));
                string.delete(len, string.length());

            }
        }
    
    }
    public List<String> wordBreakFast(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, dict, memo);
    }

    private List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length());
                List<String> suffixWays = dfs(suffix, dict, memo);
                for (String sentence : suffixWays) {
                    result.add(word + (sentence.isEmpty() ? "" : " " + sentence));
                }
            }
        }

        memo.put(s, result);
        return result;
    }
     public List<String> wordBreakSuperFast(String s, List<String> wordDict) {
        StringBuilder str = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        solve(0, str, new StringBuilder(), ans, wordDict);
        return ans;
    }

    void solve(int start, StringBuilder s, StringBuilder temp, List<String> ans, List<String> dict){
        int n = s.length();
        if(start == n){
            ans.add(temp.toString().trim());
            return;
        }

        for(int k=start; k<n; k++){
            if(dict.contains(s.substring(start, k+1))){
                int currLen = temp.length();
                temp.append(" ");
                temp.append(s.substring(start, k+1));
                solve(k+1, s, temp, ans, dict);
                temp.setLength(currLen);
            }
        }
        return;
    }
}