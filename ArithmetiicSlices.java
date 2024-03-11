public class ArithmetiicSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int count=0;
        int res=0;
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                count++;
                res+=count;
            }else{
                count=0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ArithmetiicSlices as=new ArithmetiicSlices();
        System.err.println(as.numberOfArithmeticSlices(new int[]{ 2, 4, 6, 8, 10}));
    }
}
