package problemsolvingIII;

public class SumofXORofallPairs {
    static void main() {
        System.out.println(sumXOR(new int[]{1, 2, 3, 4}));
    }

    public static long sumXOR(int[] arr) {
        // code here
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            for (int num : arr) {
                if ((num>>i & 1) == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            sum+= (long) ((long) zero *one*(1L<<i));
        }
        return sum;
    }
}