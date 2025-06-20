
import java.util.HashMap;

public class MinimumNumberofOperationstoMakeElementsinArrayDistinct {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[] { 1, 2, 3, 4, 2, 3, 3, 5, 7 }));
    }

    public static int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        int n = nums.length;
        int idx = 0;
        boolean remove = false;
        while (idx < n) {
            remove = false;
            for (int value : freq.values()) {
                if (value > 1) {
                    remove = true;
                    break;
                }
            }
            System.out.print(freq);
            System.out.println();

            if (!remove) {
                break;
            }
            int rep = 0;
            while (idx < n && rep < 3) {
                System.out.println(nums[idx]);
                freq.put(nums[idx], freq.getOrDefault(nums[idx], 0) - 1);
                idx++;
                System.out.print(freq);
                System.out.println();
                rep++;
            }
            result++;
        }
        return result;
    }

    public int minimumOperations2(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[101];
        for (int i = n - 1; i >= 0; i--) {
            if (seen[nums[i]])
                return i / 3 + 1;
            else
                seen[nums[i]] = true;
        }
        return 0;
    }
}
