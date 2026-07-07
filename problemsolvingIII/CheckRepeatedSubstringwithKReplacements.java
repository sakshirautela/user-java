package problemsolvingIII;

import java.util.HashMap;
import java.util.HashSet;

public class CheckRepeatedSubstringwithKReplacements {
    static void main() {
        System.out.println(kSubstr("abcdabcd",2));
    }
        public static boolean kSubstr(String s, int k) {
            // code here
            HashMap<String,Integer> set = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            int len =0;
            for(int i=0;i<s.length();i++){
                sb.append(s.charAt(i));
                len++;
                if(len==k){
                    set.put(sb.toString(),set.getOrDefault(sb.toString(),0)+1);
                    sb = new StringBuilder();
                    len = 0;
                }
            }
            int min=Integer.MAX_VALUE;
            if(set.size()<=2){
                for(String str:set.keySet()){
                    if(set.get(str)<min){
                        min=set.get(str);
                    }
                }
            }
            System.out.println(set);
            if(set.size()==1){
                return true;
            }else if(set.size()==2){
                if(min==1){
                    return true;
                }
            }
            return false;
    }
}
