public class PermuteSample {
    public static void main(String[] args) {
        getPermutation("abc","");
    }
    public static void getPermutation(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            getPermutation(newStr,ans+ch);
        }
    }
}
