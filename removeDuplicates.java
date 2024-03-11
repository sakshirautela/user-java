public class removeDuplicates {
    public static  String removeDuplicate(String s) {
        boolean[] map = new boolean[26];
        String result="";
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if(map[idx]!=true){
                map[idx] = true;
                result+=s.charAt(i);
            }
            
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicate("abbaca"));
    }    
}