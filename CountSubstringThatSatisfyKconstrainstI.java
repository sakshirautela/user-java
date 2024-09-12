public class CountSubstringThatSatisfyKconstrainstI {
    public static boolean count(int k,String s){
        int one=0;
        int two=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }
            if(s.charAt(i)=='0'){
                two++;
            }
        }
        return (one<=k || two<=k);
    }
    public static int countKConstraintSubstrings(String s, int k) {
        int res=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(count(k,s.substring(i,j+1))){
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(countKConstraintSubstrings("10101",1));
    }
}
