import java.util.*;
public class ReductionOperationsToMakeArrayEqual {
    public static int reductionOperations(int[] nums) {
        int n=nums.length;
        int op=0;
        Arrays.sort(nums);
        for(int i =n-1;i>=1;i--){
            if(nums[i]!=nums[i-1]){
                op+=n-i;
            }
        }
        return op;
    }
    
    public int reductionOperations2(int[] nums) {
        int n = nums.length;
        int[] freq = new int[50001];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int res = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                operations += freq[i];
                res += operations - freq[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[]{1,4,4,4}));
    }
}