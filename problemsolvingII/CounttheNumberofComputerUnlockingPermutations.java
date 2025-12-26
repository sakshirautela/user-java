import java.util.HashMap;

public class CounttheNumberofComputerUnlockingPermutations {

    public static void main(String[] args) {
        System.out.println(countPermutations(new int[]{}));
    }

    public static int countPermutations(int[] complexity) {
        long result = 1;
        int mod = 1000000007;
        int n = complexity.length;
        int first = complexity[0];
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= first) {
                return 0;
            }
            result=(result*i)%mod;
        }
        return Math.toIntExact(result);
    }
}