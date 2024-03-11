import java.util.Arrays;
 
 /*int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}*/
class SampleSolution{
    /*public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //if(nums[i]==nums[i+1]){
              //  nums
                System.out.println(nums[i]);
            }
        }
    }*/
    public static void main(String[] args){
       // System.out.println("hello");
       int[] nums={1,4,5,3,2,6,7,8,5,3,2};
       int n=nums.length;
       int[] arr= new int[n];
       Arrays.sort(nums);
        
            //System.out.println(nums);
        for(int i=0;i<nums.length;i++){
           
            if(nums[i]==nums[i+1]){
                continue;
            }
            else{
                arr[i]=nums[i];
            }
        }
        for(int i=0;i<arr.length-1;i++){
            //if(nums[i]==nums[i+1]){
              //  nums
                System.out.println(arr[i]);
            }
        
    }

    
}