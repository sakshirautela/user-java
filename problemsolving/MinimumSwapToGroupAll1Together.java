
import java.util.Arrays;

public class MinimumSwapToGroupAll1Together {
    public static int minSwaps(int[] nums) {
        if(nums.length<=2){
            return 0;
        }
        int k=Arrays.stream(nums).sum();
        int n=nums.length;
        int count=0; //count zeroes
        for (int i = 0; i < k; i++) {
            count+=nums[i];
        }
        int result=count;
        for(int i=k;i<k+n;i++){
            count+=nums[i%n]-nums[(i-k+n)%n];
            result=Math.max(result,count);
        }
        return k-result;
    }
    public static void main(String agrs[]){
        System.out.println(minSwaps(new int[]{0,1,1,1,0,0,1,1,0}));
    }
}
