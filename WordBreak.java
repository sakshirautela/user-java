import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String s, String[] wordDict) {
        HashSet<String> hs =new HashSet();
        for(int i=0;i<wordDict.length;i++){
            hs.add(wordDict[i]);
        }
        return helper(s, hs,new HashMap<>());
    }
    public static boolean helper(String str,HashSet<String> hs,HashMap<String,Boolean> temp){
        if(str.equals("")){
            return true;
        }
        if(!temp.containsKey(str)){
            boolean result=false;
            for(String word:hs){
                if(str.indexOf(word)==0){
                    if(str.equals(word)){
                        return true;
                    }else{
                        result=helper(str.substring(word.length()), hs,temp);
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
    public static void main(String[] args) {
        System.out.println(wordBreak("abcd",new String[]{"a","abc","cd","b"}));
    }
}