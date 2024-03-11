public class Duplicate {
    public static void main(String rags[]){
        int[] nums={1,2,3,1};
        boolean bool=false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    bool=true;
                    break;
                }
            }
        }
        System.out.println(bool);
    }
}
