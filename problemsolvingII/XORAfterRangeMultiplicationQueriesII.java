import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class XORAfterRangeMultiplicationQueriesII {
    static void main() {
        System.out.println(xorAfterQueries(new int[]{1, 1, 1}, new int[][]{{0, 2, 1, 4}}));
    }

    static long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        int n = nums.length;
        int lim = (int) Math.sqrt(n);
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int val = query[3];
            int k = query[2];
            if (k < lim) {
                map.putIfAbsent(k, new ArrayList<>());
                map.get(k).add(new int[]{left, right, val});
            } else {
                for (; left <= right; left += k) {
                    long mul = (long) nums[left] * val;
                    nums[left] = Math.toIntExact(mul % mod);
                }
            }
        }
        for (int i = 1; i < lim; i++) {
            if (map.containsKey(i)) {
                long[] diff = new long[n + i + 1];
                Arrays.fill(diff, 1);
                for (int[] query : map.get(i)) {
                    int left = query[0];
                    int right = query[1];
                    int val = query[2];
                    int R = (left + ((right - left) / i) * i);
                    int stopper = R + i;
                    diff[left] = (diff[left] * val) % mod;

                    long vinv = modPow(val, mod - 2, mod);
                    diff[stopper] = (diff[stopper] * vinv) % mod;
                }
                for (int j = 0; j < n; j++) {
                    if (j - i >= 0) {
                        diff[j] = (diff[j] * diff[j - i]) % mod;

                    }
                }
                for (int j = 0; j < n; j++) {
                    nums[j] = Math.toIntExact(((long) nums[j] * diff[j]) % mod);
                }
            }
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

}
