public class Repeating {
    public static void main(String args[]){
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;
        int count=0;
        //int[] result=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(val==nums[i]){
                continue;
            }
            nums[j]=nums[i];
            System.out.println(nums[j]);
            j++;
            
        }
        System.out.println(j);
    }
    
}
