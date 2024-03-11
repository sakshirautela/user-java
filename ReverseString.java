import java.util.ArrayList;
import java.util.HashSet;
public class ReverseString {
    public static void main(String[] args) {
        //String str = "Sakshi Ruatela";
        String str="Vipin Bhan dar i";
        str.trim();  
        String result="";
        String s="";
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                hs.add(i);
            }
            else{
                s=s+str.charAt(i);
            }
        }
        System.out.println(s);
        System.out.println(hs);

        int j=0;
        for (int i =str.length();i++ ){
            if(hs.contains(i)){
                result=" "+result;
                hs.remove(i);
            }
            else{
                result=s.charAt(j)+result;
                j++;    
            }
        }
        System.out.println(result);
    }
}
