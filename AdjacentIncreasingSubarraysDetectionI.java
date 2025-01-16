import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AdjacentIncreasingSubarraysDetectionI {
    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < k * 2) {
            return false;
        }
        for (int i = 0; i < n - k * 2; i++) {
            if (valid(i, nums, k) && valid(i + k, nums, k)) {
                return true;
            }
        }
        return false;
    }

    private static boolean valid(int i, List<Integer> nums, int k) {
        for( int idx=i;idx<i+k-1;idx++){
            if(nums.get(i)>=nums.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                hasIncreasingSubarrays(new ArrayList<Integer>(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)), 3));
    }
}