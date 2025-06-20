import java.util.Arrays;
import java.util.Comparator;

public class SortJumbleNumbers {
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array of Integer objects to allow sorting with custom comparator
        Integer[] originalNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Sort based on jumbled mapping
        Arrays.sort(originalNums, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return getMappedValue(a, mapping) - getMappedValue(b, mapping);
            }
        });

        // Convert back to int[]
        return Arrays.stream(originalNums).mapToInt(i -> i).toArray();
    }

    private static int getMappedValue(int num, int[] mapping) {
        if (num == 0) return mapping[0];
        int result = 0;
        int multiplier = 1;
        while (num > 0) {
            int digit = num % 10;
            result += mapping[digit] * multiplier;
            multiplier *= 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String args[]) {
        int[] mapping = {2, 1, 4, 8, 6, 3, 0, 9, 7, 5};
        int[] nums = {990, 332, 981};
        int[] res = sortJumbled(mapping, nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
        // Example output: 981 990 332
    }
}
