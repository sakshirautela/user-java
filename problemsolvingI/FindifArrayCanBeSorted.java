
import java.util.Arrays;
import java.util.HashMap;

public class FindifArrayCanBeSorted {
    public static boolean canSortArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : nums) {
            hm.put(i, Integer.bitCount(i));
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                } else if (hm.get(nums[i]) == hm.get(nums[j])) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canSortArray2(int[] nums) {
        int n = nums.length;

        // Copy the original array to values
        int[] values = Arrays.copyOf(nums, n);

        // First Pass: Iterate from left to right
        // Goal: Move the maximum value of each segment as far right as possible
        for (int i = 0; i < n - 1; i++) {
            if (values[i] <= values[i + 1])
                continue;
            else {
                // Count the number of set bits using Integer.bitCount
                if (Integer.bitCount(values[i]) == Integer.bitCount(values[i + 1])) {
                    // Swap them if they have the same number of set bits
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                } else
                    return false; // Return false if they cannot be swapped
            }
        }

        // Second Pass: Iterate from right to left
        // Goal: Move the minimum value of each segment as far left as possible
        for (int i = n - 1; i >= 1; i--) {
            if (values[i] >= values[i - 1])
                continue;
            else {
                // Count the number of set bits using Integer.bitCount
                if (Integer.bitCount(values[i]) == Integer.bitCount(values[i - 1])) {
                    // Swap them if they have the same number of set bits
                    int temp = values[i];
                    values[i] = values[i - 1];
                    values[i - 1] = temp;
                } else
                    return false; // Return false if they cannot be swapped
            }
        }

        // If both passes complete without returning false, the array can be sorted
        return true;
    }

    public static void main(String args[]) {
        System.out.println(canSortArray(new int[] { 1, 2, 3, 4 }));
    }
}
