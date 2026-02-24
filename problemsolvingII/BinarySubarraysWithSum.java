import java.util.HashMap;

public class BinarySubarraysWithSum {
    static void main() {
        System.out.println(numSubarraysWithSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}