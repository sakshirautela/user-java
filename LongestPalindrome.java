//wrong code 
class LongestPalindrome {
    public static int longestPalindrome(String s) {
        String res=null;
        for(int i=s.length();i>=0;i--){
            String str=s.substring(0,i);
            if(isPalindrome(str)){
                res=str;
                break;
            }
        }
        return res.length();
    }
    public static boolean isPalindrome(String str){
        int s=0;
        int e=str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=(str.charAt(e))){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bccccd"));
    }
}    