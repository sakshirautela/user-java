import java.util.*;
public class DivideArrayMaxDiffrence {
    public static int[][] divideArray(int[] nums, int k) {
        if(nums.length%3!=0){
            return new int[0][0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.err.print(nums[i]+" ");
        }
        System.err.println();
        int n=nums.length/3;
        int res[][]=new int[n][3];
        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
            if(b==0){
                res[a][b++]=nums[i];
            }
            else if(nums[i]-nums[i-1]<=k){
                res[a][b++]=nums[i];
                if(b==3){
                    b=0;
                    a++;
                }
            }else{
                return new int[0][0];
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[][] array=divideArray(new int[]{15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2}, 2);
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}