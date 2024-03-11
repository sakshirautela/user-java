import java.util.ArrayList;
import java.util.List;

public class srt {
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
        int k = 1;
        int sum = 0;
        String result = "";
        int carry = 0;
        for (int i = n2.length - 1; i >= 0; i--) {
            for (int j = n1.length - 1; j >= 0; j--) {
                int num = (n1[j] * n2[i]);
                if (carry != 0) {
                    num = (num) + carry;
                }

                carry = num / 10;
                // k = k * 10;
                // c=num%10;
                if (i == n2.length - 1) {
                    result = String.valueOf(num) + result;
                } else {

                    if (carry != 0) {
                        int yy = 0;
                        if (result.charAt(i) != ' ')
                            yy = (result.charAt(i) - '0') + carry + num;

                        else
                            result = String.valueOf(num) + result;

                    } else

                    {
                        int yy = 0;
                        if (result.charAt(i) != ' ')
                            yy = (result.charAt(i) - '0') + carry + num;
                            result.valueOf(i) =(result.charAt(i) - '0')1
                        else
                            result = String.valueOf(num) + result;

                    }

                }

            }

            // System.out.println(mul);
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