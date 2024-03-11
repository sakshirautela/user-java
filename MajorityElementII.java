import java.util.*;
public class MajorityElementII {
    public static void main(String[] args){
        System.out.println(majorityElement(new int[]{1,2,2,3}));
    
    }
    private static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i:map.keySet()) {
            if(map.get(i)>=nums.length/3){
                list.add(i);
            }
        }
        return list;
    }
    // n = 10
    // n/3 = 10/3 = 3
    // So if two number exist more than 3 times, than they must have to be present
    // in the array atleast 4 times.
    // And therefore 10 - (2*4) = 2, so only 2 numbers left.
    // This is valid for all array sizes.

    // The most optimal way to find this two numbers is using Boyer Moore's Voting
    // Algo.

    // Time Complexity = O(n) to find the two numbers + O(n) to check if the numbers
    // actually exist more than {n/3} times. = O(2n) = O(n)

    // Space Complexity = O(1)
    public static List<Integer> mathod(int[] nums) {
        int num1 = 0, count1 = 0, num2 = 0, count2 = 0;
        
        // Find the numbers which exist in the array most
        for(int num : nums) {
            
            if( num == num1 ) {
                ++count1;
            } else if( num == num2 ) {
                ++count2;
            } else if( count1 == 0 ) {
                num1 = num;
                count1 = 1;
            } else if( count2 == 0 ) {
                num2 = num;
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }
        
        // Find the total number of times {num1} and {nums2} are present in the array
        count1 = 0;
        count2 = 0;
        
        for(int num : nums) {
            if( num == num1 ) {
                ++count1;
            } else if( num == num2 ) {
                ++count2;
            }
        }
        
        // n/3 of array size (no need to Math.floor as the operations are performed on integers)
        int required = nums.length / 3;
        
        List<Integer> result = new ArrayList<Integer>();
        
        // Add the numbers to the result if they exist more than {n/3} times.
        if( count1 > required ) {
            result.add( num1 );
        }
        
        if( count2 > required ) {
            result.add( num2 );
        }
        
        return result;
    }
}
