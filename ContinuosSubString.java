public class ContinuosSubString {
    public static void main(String[] args) {
        //System.out.println(subString("abcs"));
        System.out.println(correct("yrpjofyzubfsiypfre"));
    }
    public static String subString(String str){
        String result="";
        for(int i=0;i<str.length();i++){
            for (int j = i+1; j < str.length(); j++) {
                String a=str.substring(i,j);
                if( result.length()<a.length() && continguous(a)){
                    result=a;
                }
            }
        }
        return result;
    }
    public static boolean continguous(String s){
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i)+1!=s.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
    public static int correct(String s){
        int total_len=1;
        int len=1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)+1){
                len++;
            }
            else{
                len=1;
            }
            total_len=Math.max(len,total_len);
        }
        return total_len;
    }
}
