import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNAsequences {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences(""));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> li=new ArrayList<>();
        HashMap<String,Integer>map=new HashMap<>();
        int i=0;
        int n=s.length();
        for (int j = 10; j <n ; j++) {
            String str=s.substring(i,j);
            i++;
            if(map.containsKey(str) && map.get(str)==1){
                li.add(str);
            }
            map.put(str,map.getOrDefault(str,0)+1);
        }
        return li;
    }
}