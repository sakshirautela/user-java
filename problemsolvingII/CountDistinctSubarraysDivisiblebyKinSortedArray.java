import java.util.HashMap;
import java.util.Map;

public class CountDistinctSubarraysDivisiblebyKinSortedArray {
    public static void main(String[] args) {
        System.out.println(numGoodSubarrays(new int[]{},9));
    }

        public static long numGoodSubarrays(int[] nums, int k) {
            int n = nums.length;
            long result = 0;
            int prefix = 0;
            HashMap<Integer, Long> map = new HashMap<>();
            map.put(0,1l);
            for (int i : nums) {
                prefix = (prefix + i) % k;
                result += map.getOrDefault(prefix, 0l);
                map.put(prefix, map.getOrDefault(prefix, 0l) + 1);
            }

            for (int i = 0; i < n;) {
                int j = i;
                while (j < n && nums[i] == nums[j]) {
                    j++;
                }
                int m = j - i;
                for (int l = 1; l < m; l++)
                    if (1l*l* nums[i] % k == 0) {
                        result -= m - l;
                    }
                i=j;
            }
            return result;
        }
        public long numGoodSubarrays2(int[] as, int k) {
            long c = 0L;
            Map<Integer, Integer> map = new HashMap<>();
            long sumAll = 0L;
            long sumPartial = 0L;
            int toAddIdx = 0;
            map.put(0, 1);
            int currVal = 0;
            for (int i = 0; i < as.length; i++) {
                if (as[i] != currVal) {
                    currVal = as[i];
                    for (int j = toAddIdx; j < i; j++) {
                        sumPartial += as[j];
                        int modPartial = (int)(sumPartial % k);
                        map.put(modPartial, map.getOrDefault(modPartial, 0) + 1);
                    }
                    toAddIdx = i;
                }
                sumAll += as[i];
                int mod = (int)(sumAll % k);
                int found = map.getOrDefault(mod, 0);
                c += found;
            }
            return c;
        }
    }
