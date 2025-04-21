import java.util.*;

public class ContestqFour {
    public static void main(String[] args) {
        
        // Example usage
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int[][] queries = {{2, 2, 0, 2}, {3, 3, 3, 0}, {0, 1, 0, 1}};
        
        ContestqFour contest = new ContestqFour();
        int[] result = contest.findXValue(nums, k, queries);
        
        System.out.println(Arrays.toString(result)); // Output: [2, 2, 2]
    }
    
    public int[] findXValue(int[] nums, int k, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            
            // Update the array
            nums[index] = value;
            
            // Remove the prefix
            int[] subarray = new int[nums.length - start];
            System.arraycopy(nums, start, subarray, 0, subarray.length);
            
            // Compute suffix products mod k
            int[] suffix = new int[subarray.length + 1];
            suffix[subarray.length] = 1;
            for (int j = subarray.length - 1; j >= 0; j--) {
                suffix[j] = (suffix[j + 1] * subarray[j]) % k;
            }
            
            // Count the number of valid suffixes
            int count = 0;
            for (int j = 0; j < subarray.length; j++) {
                if (suffix[j] == x) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}