
public class MinimumEndArray {
    public static long minEnd(int n, int x) {
        int res = x;
        while (n > 0) {
            res = (res + 1) | x;
            n--;
        }
        return res;
    }

    public long minEnd2(int n, int x) {
        long result = x;
        long mask;
        n--; // Reducing n by 1 to exclude x from the iteration

        // Step 1: Iterate over each bit position with mask starting at 1 and shifting
        // left
        for (mask = 1; n > 0; mask <<= 1) {
            // Step 2: If the corresponding bit in x is 0
            if ((mask & x) == 0) {
                // Set the bit in result based on the least significant bit of n
                result |= (n & 1) * mask;
                // Shift n to the right by 1 to process the next bit
                n >>= 1;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.print(minEnd(4, 5));
    }
}
