import java.util.Collections;

public class validatePalindrome {

    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0; i<s.length(); i++)
        {
            if(Character.isLetter(s.charAt(i)))
                str+=Character.toLowerCase(s.charAt(i));
            else if(Character.isDigit(s.charAt(i)))
                str+=s.charAt(i);
        }
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        return str.equals(rev);
    }
    public static  void main(String[] args) {
        validatePalindrome a=new validatePalindrome();
        String s="Amanama";
        System.out.println(a.isPalindrome(s));

    }
}