public class VipinSjava {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        System.out.println(add(nums));
    }
    public static int add(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        final int sub(int a,int b) {
            return a-b;
        }
        return sum;
    }
}
