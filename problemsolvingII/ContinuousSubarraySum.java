import java.util.HashMap;

public class ContinuousSubarraySum {
    static void main() {
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int presum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int j = 0; j < nums.length; j++) {
            presum = (presum + nums[j]) % k;
            if (map.containsKey(presum) && j - map.get(presum) >= 2) {
                return true;
            }
            map.put(presum, j);
        }
        return false;
    }
}
