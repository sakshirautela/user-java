import java.util.HashMap;
import java.util.HashSet;

public class FirstElementwithUniqueFrequency {
    static void main() {
        System.out.println(firstUniqueFreq(new int[]{20, 10, 30, 30}));
    }

    public static int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        HashMap<Integer, Integer> freqC = new HashMap<>();
        for (int i : freq.keySet()) {
            freqC.put(freq.get(i), freqC.getOrDefault(freq.get(i), 0) + 1);
        }
        for (int i : nums) {
            if (freqC.get(freq.get(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
    public int firstUniqueFreqFast(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(nums[i], max);
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int[] freq = new int[n + 1];
        for (int i = 0; i <= max; i++) {
            if (count[i] > 0)
                freq[count[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (freq[count[nums[i]]] == 1)
                return nums[i];
        }
        return -1;
    }
}