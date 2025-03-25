import java.util.HashMap;

public class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        System.out.println(divideArray(new int[] {}));
    }

    public static boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : freq.values()) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean divideArray2(int[] nums) {
        int[] freq = new int[501];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i < 501; i++) {
            if (freq[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}