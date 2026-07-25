package problemsolvingIII;


public class NumberOfUniqueXORTripletsII {
    static void main() {

        System.out.println(uniqueXorTriplets(new int[]{1, 2, 3}));
    }

    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int v : nums) {
            max = Math.max(max, v);
        }
        int u = 1;
        while (u <= max) {
            u <<= 1;
        }
        boolean[] isPrreset = new boolean[u];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                isPrreset[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] triplet = new boolean[u];
        for (int i = 0; i < u; i++) {
            if (!isPrreset[i]) {
                continue;
            }
            for (int v : nums) {
                triplet[i ^ v] = true;
            }
        }
        int res = 0;
        for (boolean count : triplet) {
            if (count) {
                res++;
            }
        }
        return res;
    }
}
