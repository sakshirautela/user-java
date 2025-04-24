import java.util.HashMap;

public class SubarrayswithKDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k - 1);
    }

    private static int slidingWindowAtMost(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int i = 0;
        int result = 0;
        for (int j = 0; j < n; j++) {
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            while (freq.size() > k) {
                freq.put(nums[i], freq.get(nums[i]) - 1);
                if (freq.get(nums[i]) == 0) {
                    freq.remove(nums[i]);
                }
                i++;
            }
            result += j - i + 1;
        }
        return result;
    }

    // This will run the code faster, as this static block
    // make JVM to optimize the repeating code while loading
    // the static class
    static {
        for (int i = 0; i < 500; ++i)
            subarraysWithKDistinct(new int[0], 1);
    }

    public static int subarraysWithLessThanEqualToKDistinct(
            int[] nums, int k) {
        if (k == 0)
            return 0;
        int len = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int left = 0, right = 0; right < len; right++) {
            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                int occurence = map.get(nums[left]);
                if (occurence == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], occurence - 1);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static int subarraysWithLessThanEqualToKDistinct2(
            int[] nums, int k) {
        if (k == 0)
            return 0;
        int len = nums.length;
        int count = 0;
        int map[] = new int[len + 1];
        int size = 0;

        for (int left = 0, right = 0; right < len; right++) {
            if (0 == map[nums[right]]++)
                ++size;
            while (size > k) {
                if (0 == --map[nums[left]])
                    --size;
                ++left;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static int subarraysWithKDistinct2(int[] nums, int k) {

        // // Brute Force, TC: O(n*n), SC: O(n)
        // // Will Throw TLE
        // int len = nums.length;
        // int count = 0;
        // Set<Integer> set = new HashSet<>();

        // for(int i = 0; i < len; i++){
        // for(int j = i; j < len; j++){
        // set.add(nums[j]);
        // int size = set.size();
        // if(size > k) break;
        // if(size == k) count++;
        // }
        // set.clear();
        // }
        // return count;

        // // This approach will not work because it is not counting
        // // the previous combinations while increasing subarray
        // // length.
        // int len = nums.length;
        // int count = 0;
        // Map<Integer, Integer> map = new HashMap<>();

        // for(int left = 0, right = 0; right < len; right++){
        // map.put(nums[right],
        // map.getOrDefault(nums[right], 0) + 1);
        // while(map.size() > k){
        // int occurence = map.get(nums[left]);
        // if(occurence == 1){
        // map.remove(nums[left]);
        // }else{
        // map.put(nums[left], occurence - 1);
        // }
        // left++;
        // }
        // if(map.size() == k) count++;
        // }
        // return count;

        // // Optimal, TC: O(2n + 2n), SC: O(n)
        // return subarraysWithLessThanEqualToKDistinct(nums, k)
        // - subarraysWithLessThanEqualToKDistinct(nums, k - 1);

        // // Optimal Improved, TC: O(2n + 2n), SC: O(n)
        // return subarraysWithLessThanEqualToKDistinct2(nums, k)
        // - subarraysWithLessThanEqualToKDistinct2(nums, k - 1);

        // Optimal Final, TC: O(~3n), SC: O(n)
        int len = nums.length;
        int freq[] = new int[len + 1];
        int elementCount = 0;
        int result = 0;
        int left = 0;
        int mid = 0;

        for (int right = 0; right < len; right++) {
            if (++freq[nums[right]] == 1)
                elementCount++;

            while (elementCount > k) {
                if (--freq[nums[mid++]] == 0) {
                    elementCount--;
                    left = mid;
                }
            }

            while (freq[nums[mid]] > 1) {
                freq[nums[mid++]]--;
            }

            if (elementCount == k) {
                result += mid - left + 1;
            }
        }
        return result;
    }
}