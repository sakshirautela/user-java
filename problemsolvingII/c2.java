import java.util.Map;
import java.util.HashMap;
public class c2 {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{35,39,65,101,101,54,1,111,8,107,96,90,91,54,115,36,46,76,111,39,29,122,4,113,101,73,125,39,124,33,82,39},16));
        System.out.println(partitionArray(new int[]{1},1));
    }
    public static  boolean partitionArray(int[] nums, int k) {
        if (nums.length == 0 || nums.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int m = 0;
        for (int count : freq.values()) {
            m = Math.max(m, count);
        }

        return nums.length >= m * k;
    }
}
