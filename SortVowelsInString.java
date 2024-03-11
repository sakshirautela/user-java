import java.util.*;
public class SortVowelsInString {
    public static String sortVowels(String s) {
        ArrayList<Character> list = new ArrayList<Character>();        
        Set<Character> st = new HashSet<Character>();
        String str="AOUIEaouie";
        for(Character c :str.toCharArray()) {
            st.add(c);
        }
        for(int i=0;i<s.length();i++) {
            if(st.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        Collections.sort(list);
        str="";
        for(int i=0;i<s.length();i++){
            if(st.contains(s.charAt(i))){
                str+=list.get(0);
                list.remove(0);
            }
            else{
                str+=s.charAt(i);
            }
        }
        return str;

    }
    public static void main(String[] args){
        System.out.println(sortVowels("hellouU"));
    }
}