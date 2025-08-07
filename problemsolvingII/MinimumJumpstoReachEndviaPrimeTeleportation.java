import java.util.*;

public class MinimumJumpstoReachEndviaPrimeTeleportation {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{893, 786, 607, 137, 69, 381, 790, 233, 15, 42, 7, 764, 890, 269, 84, 262, 870, 514, 514, 650, 269, 485, 760, 181, 489, 107, 585, 428, 862, 563}));
    }

    static boolean[] isprime;
    static int LIM = (int) 1e6;

    static {
        isprime = new boolean[LIM];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        for (int i = 2; i * i < LIM; i++) {
            if (isprime[i]) {
                for (int j = i * i; j < LIM; j += i) {
                    isprime[j] = false;
                }
            }
        }
    }

    public static int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int idx = curr[0], jumps = curr[1];

            if (idx == n - 1) {
                return jumps;
            }


            int val = nums[idx];
            if (val > 1 && val < LIM && isprime[val]) {
                for (int j = n - 1; j > idx; j--) {
                    if (nums[j] % val == 0 && !visited[j]) {
                        visited[j] = true;
                        q.add(new int[]{j, jumps + 1});
                        break;
                    }
                }
            }
            if (idx + 1 < n && !visited[idx + 1]) {
                visited[idx + 1] = true;
                q.add(new int[]{idx + 1, jumps + 1});
            }
        }
        return -1;
    }
}
