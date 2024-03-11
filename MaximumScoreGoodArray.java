public class MaximumScoreGoodArray {
    public static int maximumScore(int[] nums, int k) {
        int l=k;
        int r=k;
        int res=nums[k];
        int curr_min=nums[k];
        while(l>0 || r<nums.length-1){
            int left=(l>0)?nums[l-1]:0;
            int right=(r<nums.length-1)?nums[r+1]:0;
            if(left>right){
                l--;
                curr_min=Math.min(curr_min,left);
            }
            else{
                r++;
                curr_min=Math.min(curr_min,right);
            }
            res=Math.max(res,(curr_min)*(r-l+1));
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(maximumScore(new int[]{1,2,3,4},3));
    }
}