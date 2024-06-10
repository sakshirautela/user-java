
import java.util.Arrays;

public class MissingFirstPositiveInteger {
    public static void main(String[] args) {
        
    }
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(nums[0]>1 || nums[n-1]<=0){
            return 1;
        }
        int sum=((n)*(n+1))/2;
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                continue;
            }
            if(i>=1 && nums[i]!=nums[i-1]){
                sum-=nums[i];
            }
        }
        return sum;
    }
}
