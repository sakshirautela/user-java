
public class MinimumOneBitOperationsIntegerToZero {
    public static int minimumOneBitOperations(int n) {
        int highestBit = Integer.highestOneBit(n);
        return n ^ (highestBit - 1) ^ minimumOneBitOperations(n - highestBit);
    }
    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(3));
    }
}
