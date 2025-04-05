public class SumofAllSubsetXORTotals {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{5,1,6}));
    }
    public static int subsetXORSum(int[] nums) {
        return subsetXORSumHelper(nums,0,nums.length,0);
    }
    private static int subsetXORSumHelper(int[] nums, int i,int n, int xor) {
        if(i==n){
            return xor;
        }
        int include=subsetXORSumHelper(nums, i+1, n, xor^nums[i]);
        int exclude=subsetXORSumHelper(nums, i+1, n, xor);
        return include+exclude;
    }
}