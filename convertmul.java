import java.util.ArrayList;
import java.util.List;

public class convertmul {
    public static void main(String args[]) {
        String num1 = "12";

        String num2 = "12";
        int[] n1 = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            n1[i] = (num1.charAt(i) - '0');
        }
        int[] n2 = new int[num2.length()];
        ;
        for (int i = 0; i < num2.length(); i++) {
            n2[i] = (num2.charAt(i) - '0');
        }
        int num=0;
        String result = "";
        int carry = 0,sum=0;
        // ArrayList<Integer> result=new ArrayList();
        // String mul=String.valueOf(n1*n2);
        for (int i = n2.length - 1; i >= 0; i--) {
            for (int j = n1.length - 1; j >= 0; j--) {
                
                 num = (n1[j] * n2[i]);
                
                System.out.println(sum);



            }


        }
        System.out.println(result);
    }

    public static int covertion(String array) {
        int digit = 0;
        for (int i = 0; i < array.length(); i++) {
            digit = (array.charAt(i) - '0');
        }
        return digit;
    }
}