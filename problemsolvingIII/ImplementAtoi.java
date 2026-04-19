package problemsolvingIII;

public class ImplementAtoi {
    static void main() {
        System.out.println(myAtoi("+460ctdg"));
    }

    public static int myAtoi(String s) {
        // code here
        int i=0;
        int n=s.length();
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        int symbol=1;
        if(i<n && (s.charAt(i)=='-'||s.charAt(i)=='+')){
            symbol=s.charAt(i)=='-'?-1:1;
            i++;
        }
        int res=0;
        while(i<n &&  s.charAt(i)>='0'&& s.charAt(i)<='9'){
            int digit=s.charAt(i)-'0';
            if(res>(Integer.MAX_VALUE-digit)/10){
                return (symbol==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=res*10+digit;
            i++;
        }
        return res*symbol;
    }
}