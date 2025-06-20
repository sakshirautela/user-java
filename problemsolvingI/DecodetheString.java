
import java.util.Stack;

public class DecodetheString {
    public static void main(String[] args) {
        System.out.println(decodeString("1[b]"));
    }
    static String decodeString(String s) {
        // code here
        String result="";
        Stack<Integer> freq=new Stack<>();
        Stack<StringBuilder> string=new Stack<>();
        int n=s.length();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)-'0'>0 && s.charAt(i)-'0'<10 ){
                freq.add(s.charAt(i)-'0');
            }else if(s.charAt(i)=='['){
                str=new StringBuilder();
            }else if(s.charAt(i)==']'){
                result=string.pop()+result;
                String a=result;
                int rep=freq.pop();
                while(rep>1){
                    rep--;
                    a=a+result;
                }
                result=a;
            }else{
                str.append(s.charAt(i));
            }
        }
        return result;
    }
}
