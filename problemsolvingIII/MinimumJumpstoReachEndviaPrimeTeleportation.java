package problemsolvingIII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumJumpstoReachEndviaPrimeTeleportation {
    static void main() {
        System.out.println(minJumps(new int[]{}));
    }
    public static int minJumps(int[] nums) {
        int n = nums.length;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int max=0;
        for (int i = 2; i*i <= max; i++) {

        }
        return 0;
    }
}
