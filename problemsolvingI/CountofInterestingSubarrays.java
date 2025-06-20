import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountofInterestingSubarrays {
    public static void main(String[] args) {
        System.out.println(countInterestingSubarrays(new ArrayList<>(), 2, 1));
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long res = 0;
        int prefix = 0;
        cnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            res += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1);
        }
        return res;
    }

    public long countInterestingSubarrays2(List<Integer> nums, int modulo, int k) {

        int n = nums.size();
        if (k > n)
            return 0;

        int[] count = new int[n + 1];
        count[0] = 1;

        long ans = 0;
        int sum = 0;
        for (int x : nums) {
            x %= modulo;
            if (x == k)
                ++sum;

            sum %= modulo;
            int r = sum - k;
            if (r < 0)
                r += modulo;
            if (r < n)
                ans += count[r];

            count[sum]++;
        }

        return ans;
    }
}
