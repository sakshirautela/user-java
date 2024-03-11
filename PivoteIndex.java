public class PivoteIndex {
    public static void main(String args[]) {
        int[] nums={1,3};
        int[] array=new int[nums.length];
        int j=0;
        //int idx=0;
        int target=1;
        int t=0;
         for(int i=0;i<nums.length;i++){
                 if(target==nums[i]){
                     t=target;
                 }
             }
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
                else{
                    System.out.println("none");
                }
            }
        //int result=pivot(result,target);
        
    }

}
