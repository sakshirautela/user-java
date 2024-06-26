public class NumberOfNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int left=0;
        int n=0;
        int ans=0;
        int i=0;
        int h=0;
        int d=0;
        while (left<nums.length && i<nums.length) {
            if(nums[i]%2!=0){
                n++;
            }
            if(n==0){
                h=i;
            }
            if(n==k){
                d=i;
            }
            if(n==k+1){
                ans+=(d-(left))*(h+1-left);
                n=0;
                left++;
            }
            i++;
        }
        return ans-1;
    }
    public static void main(String[] args){
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2));
    }
}