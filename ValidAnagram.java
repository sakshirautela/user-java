import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s="abc";
        String t="bca";
        System.out.println(isValid(s,t));
        
    }
    public static boolean isValid(String s,String t){
        HashMap<Character,Integer> hm=new HashMap();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            if(hm.get(t.charAt(i))!=null){
                if(hm.get(t.charAt(i))==1){
                    hm.remove(t.charAt(i));
                }
                else{
                    hm.put(t.charAt(i),hm.get(t.charAt(i))-1);
                }
            }
            else{
                return false;
            }
        }
        return hm.isEmpty()?true:false;
    }
}
