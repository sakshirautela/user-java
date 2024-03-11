public class LongestSubarrayWithMaximumBitwiseAND {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,2,2};
        System.out.println(longestSubarray(arr));
    }
    public static int longestSubarray(int[] nums) {
        int res=0;
       int max=0;
       int count=0;
       for(int i=0;i<nums.length;i++){
           max=Math.max(nums[i],max);
       } 
       for(int i=0;i<nums.length;i++){
           if(nums[i]==max){
               count++;
           }
           else{
               count=0;
           }
           res=Math.max(count,res);
       } 
       return res;
    }
    public int longestSubarray2(int[] nums) {
        int max = 0;
        int result = 0, length = 0;

        for(int n : nums){
            max = Math.max(max, n);
        }

        for(int n : nums){
            if(n == max){
                result = Math.max(result, ++length);
            }
            else{
                length = 0;
            }
        }

        return result;
    }
}
