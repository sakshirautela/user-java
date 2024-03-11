
public class Search {
    /*public static void pivot(int[] result,target){
            int pvt=target;
            for(int i=0;i<result.length;i++){
                if(pvt==result[i]){
                    pvt_idx=i;
                }
            }
        }*/
    public static void main(String args[]) {
        int[] nums={4,5,6,7,8,1,2};
        int target=1;
        int t=0;
        if(target == nums[0]){
            System.out.println(0);
        }
        if(target == nums[nums.length-1]){
            System.out.println(nums.length-1);
        }
         for(int i=0;i<nums.length;i++){
                 if(target==nums[i]){
                     t=target;
                 }
             }
        int[] array=new int[nums.length];
        int j=0;
        //int idx=0;
        
        for(int i=t;i<nums.length;i++){
            array[j]=nums[i];
            j++;
        }

        for(int i=0;i<t;i++){
            array[j]=nums[i];
            j++;
        }
        
            for(int i=0;i<array.length;i++){
                if(target==array[i]){
                    System.out.println(i);
                }
            }
        //int result=pivot(result,target);
        //return -1;
        
    }
}