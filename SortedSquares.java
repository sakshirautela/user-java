import java.util.Arrays;

class SortedSquares {
    public static void main(String[] args) {
        int[] nums={0,-1,3,2,4,5};
        int[] res= new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            //int data=Math.abs(nums[i]);
            // System.out.println(nums[i]);
            res[i]=(int)Math.sqrt(data);
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(res[i]);
        }
        //return nums;
    }
}