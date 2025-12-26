import java.util.HashMap;

public class CountSpecialTripates {
    public static void main(String[] args) {
        System.out.println(specialTriplets(new int[]{0, 1, 0, 0}));
    }

    public static int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> prev = new HashMap<>();
        int mod=1000000007;
        int n = nums.length;
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        long  result = 0;
        for (int i = 0; i < n - 1; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) - 1);
            int next = freq.getOrDefault(nums[i] * 2, 0);
            int pre = prev.getOrDefault(nums[i] * 2, 0);
            result = ((result + ((long) next * pre)) % mod);
            prev.put(nums[i], prev.getOrDefault(nums[i], 0) + 1);
        }
        return Math.toIntExact(result);
    }
    static int[] f = new int[100001];
    static int[] r = new int[100001];
    final int MOD = 1_000_000_007;
    public int specialTripletsFast(int[] nums) {
        for(int n: nums) {
            r[n]++;
        }
        int count = 0, t;
        for(int n: nums) {
            r[n]--;
            t = n << 1;
            if(t < f.length) {
                count = (count + (int)((1L * f[t] * r[t]) % MOD)) % MOD;
            }
            f[n]++;
        }
        for(int n: nums) {
            f[n] = 0;
        }
        return count;
    }
}