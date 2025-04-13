public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber(""));
    }

    public static boolean isNumber(String s) {
        int idx=(s.charAt(0)=='-'|| s.charAt(0)=='+')?1:0;
        if(s.charAt(idx+1)=='-' || s.charAt(idx+1)=='+'){
            return false;
        }
        int isE=-1;
        int n=s.length();
        for(int i=idx;i<n;i++){
            
        }
    }
}