import java.util.Arrays;

public class MinDifferenceBtwLargestSmallIn3moves {
    public static int minDifference(int[] nums) {
        if(nums.length<5){
            return 0;
        }
        int result=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n=nums.length;
        result = Math.min(result,nums[n-4]-nums[0]);        
        result = Math.min(result,nums[n-1]-nums[3]);
        result = Math.min(result,nums[n-2]-nums[2]);
        result = Math.min(result,nums[n-3]-nums[1]);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{ 0,1,1,4,6,6,6}));
    }
}