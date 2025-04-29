
public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[] {}));
    }

    public static int maxAscendingSum(int[] nums) {
        int result=nums[0];
        int sum=result;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
            }else{
                result=Math.max(sum,result);
                sum=nums[i];
            }
        }
        return Math.max(result,sum);
    }
}
