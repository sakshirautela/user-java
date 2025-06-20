import java.util.List;

public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int result = 0;
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(j - i) >= x && Math.abs(nums.get(i) - nums.get(j)) < min) {
                    result = Math.abs(nums.get(i) - nums.get(j));
                }
            }
        }
        return result;
    }
}
