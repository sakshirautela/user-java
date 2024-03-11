public class DivideTwoInteger {
    public static void main(String[] args) {
        int divisor = -1;
        long dividend = -2147483648;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        dividend =  Math.abs(dividend);
        long div;
        divisor = Math.abs(divisor);
        if (divisor == 1) {
            div = sign * dividend;
        }
        else{
            div =  sign*(dividend / divisor);

        }

        System.out.println(div );
    }
}
