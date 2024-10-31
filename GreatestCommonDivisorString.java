public class  GreatestCommonDivisorString{
    public static void main(String ars[]){
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }
    public static boolean Divisor(String s,String str){
        int len=s.length();
        int idx=0;
        while (idx<str.length()) {
            if((idx+len)<=str.length() && str.substring(idx,idx+len).equals(s)){
                idx+=len;
            }else{
                return false;
            }
        }
        return true;
    }
    public static String gcdOfStrings(String str1, String str2) {
        String s="";
        for (int i = 0; i < str1.length(); i++) {
            s+=str1.charAt(i);
            if(Divisor(s, str2) && Divisor(s, str1)){
                return s;
            }
        }
        return "";
    }
}