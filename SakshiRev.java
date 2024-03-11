import java.util.HashMap;

public class SakshiRev {
    public static void main(String[] args) {
        String s="Vipin Bhandari";
        String res="";
        String re = "";
        HashMap<Integer,Integer> hs=new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                hs.put(i,1);
            }
            else{
                re+=s.charAt(i);
            }
        }
        int n=re.length()-1;
        for (int i=0;i <= s.length()-1; i++) {
            if(hs.containsKey(i)){
                res=" "+res;
            }
            else{
                res = re.charAt(n)+res;
                n--;
            }
        }
        System.out.println(res);
    }
}
