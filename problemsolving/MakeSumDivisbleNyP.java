
import java.util.HashMap;

public class MakeSumDivisbleNyP {
    public static void main(String[] args) {

    }

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        // Step 1: Calculate total sum and target remainder
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        int target = totalSum % p;
        if (target == 0) {
            return 0; // The array is already divisible by p
        }

        // Step 2: Use a hash map to track prefix sum mod p
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // To handle the case where the whole prefix is the answer
        int currentSum = 0;
        int minLen = n;

        // Step 3: Iterate over the array
        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            // Calculate what we need to remove
            int needed = (currentSum - target + p) % p;

            // If we have seen the needed remainder, we can consider this subarray
            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            // Store the current remainder and index
            modMap.put(currentSum, i);
        }

        // Step 4: Return result
        return minLen == n ? -1 : minLen;
    }
    public int minSubarray2(int[] nums, int p) {
        int n = nums.length;
        double sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % p == 0.0)
            return 0;
        HashMap<Integer, Integer> mh = new HashMap<>();
        sum %= p;
        int s = (int)(sum);
        int len = n, mod = 0;
        for (int i = 0; i < n; i++) {
            if (len == 1)
                return 1;
            mod = (nums[i] + mod) % p;
            mh.put(mod, i);
            if (s == mod)
                len = Math.min(i + 1, len);
            if (mh.get((mod + p - s) % p) != null) 
                len = Math.min(len, i -  mh.get((mod + p - s) % p));
        }
        if(len==n)
            return -1;
        return len;
    }
}
