public class AddOneBit {
    public static void main(String[] args) {
        byte a = 6;

        // Print decimal values
        System.out.println("Decimal values:");
        System.out.println("a: " + a);
        System.out.println("-a: " + (-a));
        System.out.println("-~a: " + (-~a));

        // Print binary values
        System.out.println("\nBinary values:");
        System.out.println("a:    " + Integer.toBinaryString(a & 0xFF));       // 00000110
        System.out.println("-a:   " + Integer.toBinaryString(-a & 0xFF));      // 11111010 (2's complement of 6)
        System.out.println("-~a:  " + Integer.toBinaryString(-~a & 0xFF));     // should be 00000101, which is 5
    }
}
