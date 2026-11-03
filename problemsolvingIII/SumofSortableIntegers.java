package problemsolvingIII;

public class SumofSortableIntegers {
    static void main() {
        System.out.println(sortableIntegers(new int[]{5,7,7,8,8,10}));
    }
    public static int sortableIntegers(int[] nums) {
        int res=0;
        int peak=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                peak++;
            }
        }
        for(int k = 0; k <=Math.sqrt(n); k++){
            if(n%k==0){

            }
        }
        return 0;
    }
}
