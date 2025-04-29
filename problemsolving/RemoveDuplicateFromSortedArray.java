
public class RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int n=nums.length;
        //int[] arr= new int[n];
        int j=0;
        for(int i=0;i<nums.length;i++){
            
            if(i<n-1 && nums[i]==nums[i+1]){
                continue;
            }
            nums[j]=nums[i];
            j++;
        }
        return j;
    }
    public static void main(String args[]){
        System.out.println(removeDuplicates(new int[]{}));
    }
}
