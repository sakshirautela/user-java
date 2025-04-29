public class ContestqTwo {
    public static void main(String[] args) {
       // System.out.println(maximumPossibleSize(new int[]{1, 2, 3, 4, 5})); // Output: 5
        System.out.println(maximumPossibleSize(new int[]{5, 4, 3, 2, 1})); // Output: 1
    }

    public static int maximumPossibleSize(int[] nums) {
        int n = nums.length;
        int max=0;
        int len=0;
        int prev=nums[0];
        int result=n;
        for(int i=1;i<n;i++){
            if(nums[i]>=prev){
                prev=nums[i];
                result-=len;
                len=0;
            }else{
                len++;
            }
            prev=nums[i];
        }
        return result;
    }
}
