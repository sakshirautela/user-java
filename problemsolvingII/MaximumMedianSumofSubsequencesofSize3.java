import java.util.Arrays;

public class MaximumMedianSumofSubsequencesofSize3 {
    public static void main(String[] args) {
        System.out.println(maximumMedianSum(new int[]{2,1,3,2,1,3}));
    }
        public static  long maximumMedianSum(int[] nums) {
long result=0;
            Arrays.sort(nums);
            int i=0;
            int j=nums.length-1;
            while (i<j){
                result+=nums[j-1];
                j-=2;
                i++;
            }
            return result;
        }
}
