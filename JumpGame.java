public class JumpGame {
    public boolean canJump(int[] nums) {
        int next=nums[0],jumps=0;
        if(nums.length<=1){
            return true;
        }
        for(int i=0;i<nums.length;i++){
            if(next<=i && nums[i]==0){
                return false;
            }
            if(i+nums[i]>next){
                next=i+nums[i];
            }
            if(next>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}