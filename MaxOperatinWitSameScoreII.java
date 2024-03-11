public class MaxOperatinWitSameScoreII {
    public static int maxOperations(int[] nums) {
        int sum=nums[0]+nums[1];
        int end=nums.length-1;
        int start=2;
        int count=0;
        while(start<end && start<nums.length){
            if(nums[start]+nums[end]==sum){
                end--;
                start++;
                count++;
            }else if(nums[end]+nums[end-1]==sum){
                end-=2;
                count++;
            }else{
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,2,1,2,3,4}));
    }
}