import java.util.Arrays;

public class MaximumAlternatingSquare {
    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[]{}));
    }
        public static long maxAlternatingSum(int[] nums) {
int n=nums.length;
long sum=0;
            for (int i = 0; i < n; i++) {
                nums[i]=nums[i]*nums[i];
            }
            Arrays.sort(nums);
            int i=0,j=n-1;
            while (i<j){
                sum-= (long) nums[i] ;
                sum+= (long) nums[j] ;
                j--;
                i++;
            }
            if(i==j){
                sum+= (long) nums[j] ;

            }
            return sum;
        }
}
