import java.util.*;
public class MultiplyString {
    public static String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] mul=new int[m+n];
        for (int i = m-1; i >=0; i--) {
            int a=num1.charAt(i)-'0';
            for (int j = n-1; j >=0;j--){
                int b=num2.charAt(j)-'0';
                int multiple=a*b;
                int idx1=i+j,idx2=i+j+1;
                int sum=multiple+mul[idx2];
                mul[idx1]+=sum/10;
                mul[idx2]+=sum%10;
            }
        }
        StringBuilder result=new StringBuilder();
        String res="";
        for(int digit: mul){
            if(!(digit==0 && result.length()==0)){
                result.append(digit);
                res=res+digit;
            }
        }
        return (result.length()==0)?"0":res;
    }
    public static void main(String[] args) {
        System.out.println(multiply("123","3"));
    }        
}