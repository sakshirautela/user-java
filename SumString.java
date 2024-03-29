public class SumString {
    public static void main(String[] args) {
        String num1="11";
        String num2="123";
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        String result = "";
        int carry = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i ++) {
            int c1 = 0;
            int c2 = 0;
            if (i < num1.length()) {
                c1 = num1.charAt(i) - '0';
            }
            if (i < num2.length()) {
                c2 = num2.charAt(i) - '0';
            }
            int sum = (c1 + c2 )+ carry;
            int digit = sum % 10;
            carry = sum / 10;
            result = digit + result;
        }
        if (carry != 0) {
            result = carry + result;
        }
        System.out.println(result);
    }        
    
}