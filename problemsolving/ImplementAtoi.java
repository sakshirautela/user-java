public class ImplementAtoi {
    public static int myAtoi(String s) {
        // Your code here
        s = s.trim();
        int sign = (s.charAt(0) != '-') ? 1 : -1;
        int result = 0;
        int len = s.length();
        int index = (s.charAt(0) != '-' && s.charAt(0) != '+') ? 0 : 1;
        while (index < len) {
            int digit = s.charAt(index) - '0';
            if(digit>9 || digit<0){
                break;
            }
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;

    }

    public static void main(String args[]) {
        System.out.println(myAtoi("   325-"));
    }
}
