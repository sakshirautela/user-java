
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int ptr=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0 && ptr>=0){
                int temp=nums[i];
                nums[i]=nums[ptr];
                nums[ptr]=temp;
                ptr++;
            }
            //Arrays.swap(nums,ptr,i);
            
        }
        //return nums;
    }
    public static void main(String args[]){
        int[] arr={0,1,0,3,12};
        moveZeroes(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
