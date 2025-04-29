import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {

    }
    static List<String> li;
    static StringBuilder sb;
    public List<String> wordBreak(String s, List<String> wordDict) {
        sb=new StringBuilder();
        li=new ArrayList<>();
        helper(s, new HashSet(wordDict),new HashMap());
        return li;
    }
    public static boolean helper(String str,HashSet<String> hs,HashMap<String,Boolean> temp){
        if(str.equals("")){
            li.add(sb.toString().trim());
            return  true;
        }
        if(!temp.containsKey(str)){
            boolean result=false;
            for(String word:hs){
                if(str.indexOf(word)==0){
                    if(str.equals(word)){
                        li.add(sb.toString().trim());
                        return true;
                    }else{
                        result=helper(str.substring(word.length()), hs,temp);
                        sb.append(" "+word);
                        if(result){
                            break;
                        }
                    }
                }
            }
            temp.put(str,result);
        }
        return temp.get(str);
    }
}
