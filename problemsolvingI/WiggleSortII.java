
import java.util.Arrays;

public class WiggleSortII {
    public static void wiggleSort(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int mid=(n-1)/2;
        int end=n-1;
        int res[]=new int[n];
        int idx=0;
        while(mid>=0 || end>(n-1)/2){
            if(idx%2==0){
                res[idx]=nums[mid];
                mid--;
            }else{
                res[idx]=nums[end];
                end--;
            }
            idx++;
        }
        for(int i=0;i<res.length;i++){
            nums[i]=res[i];
        }
    }
    public static void main(String args[]){
        int[] result={1,5,1,1,6,4};
        wiggleSort(result);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
