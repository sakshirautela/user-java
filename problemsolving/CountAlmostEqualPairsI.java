
import java.util.HashMap;

public class CountAlmostEqualPairsI {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[] {3,12,30,17,21}));
    }

    public static int countPairs(int[] nums) {
        int n = nums.length;
        int result = 0;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        HashMap<Integer, Integer> revCount = new HashMap<>();
        
        // Count the frequency of numbers and reversed numbers
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int rev = reverse(num);
            
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            revCount.put(rev, revCount.getOrDefault(rev, 0) + 1);
        }
        
        for (int num : numCount.keySet()) {
            result += numCount.get(num) * revCount.getOrDefault(num, 0);
        }
        
        for (int count : numCount.values()) {
            result += (count * (count - 1)) / 2;
        }
        
        return result;
    }
    
    private static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
