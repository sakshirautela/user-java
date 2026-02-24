import java.util.Arrays;
import java.util.HashSet;


public class PrimeNumberofSetBitsinBinaryRepresentation {
    static void main() {
        System.out.println(countPrimeSetBits(6, 10));
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        for (int i = left; i <= right; i++) {
            int c = Integer.bitCount(i);
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
    public static int countSetBit(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) count++;
            num >>>= 1;
        }
        return count;
    }
    public int countPrimeSetBitsFast(int L, int R) {
        int count = 0;
        while (L <= R)
            count += 665772 >> Integer.bitCount(L++) & 1;
        return count;
    }
}
