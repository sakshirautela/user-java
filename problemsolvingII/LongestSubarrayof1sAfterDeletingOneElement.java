public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
    }
    public static int longestSubarray(int[] nums) {
        int zero=(nums[0]==0)?0:-1;
        int zcount=zero==0?1:0;
        int prev=-1;
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==0 && zcount==0){
                zero=i;
            }else if (nums[i]==0 && zcount==1){
                res=Math.max(res,i-prev);
                prev=zero;
                zero=i;
                zcount--;
            }
        }
        if(zcount<=0){
            res=Math.max(res,nums.length-prev-1);
        }
        return res;
    }
}
