public class MinimumPairRemovaltoSortArrayI {
    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{}));
    }
    public static int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        if(isSorted(nums,n)){
            return 0;
        }
    }
    private static boolean isSorted(int[] nums, int n) {
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }
}