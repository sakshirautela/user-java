package problemsolvingIII;

public class CalculateDigitSumofaString {
    static void main() {
        System.out.println(digitSum("",9));
    }
    public static String digitSum(String s, int k) {
        int n=s.length();
        String res="";
        while (s.length()>k){
            int len=s.length();
            int sum=0;
                for(int i=0;i<len;i++){
                    sum+=s.charAt(i)-'0';
                    if(k%(i+1)==0){

                    }
                }
        }
    }
}
