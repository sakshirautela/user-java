import java.util.Arrays;

public class missingNumber {
    public static void main(String[] args) {
        int[] nums={ 7, 8, 9, 11, 12};
        Arrays.sort(nums);
        int n=nums[nums.length-1];
        int tsum=n*(n+1)/2;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
        }
        int missing=tsum-sum;
        if(missing==0 && isPresent(nums,0)){
            missing=n+1;
        }
        System.out.println(missing);
    }
    
    private static boolean isPresent(int[] nums, int i) {
        for (int j = 0; j < nums.length; j++) {
            if(nums[i]==0){
                return true;
            }
        }
        return false;
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int x = 0;
            for (int i = 0; i < nums.length; i++) {
                x ^= i;
                x ^= nums[i];
            }
            return x ^= nums.length;
        }
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        // 1st Approch

        // Arrays.sort(nums);
        // int k = 0;
        // for(int i = 0;i<nums.length;i++){
        // if(nums[i] != k){
        // return k;
        // }
        // k++;
        // }
        // return k;

        // 2nd Approch

        int n = nums.length;
        int i = 0;
        int sum = 0;
        while (i < nums.length)
            sum += nums[i++];
        int sumExpected = n * (n + 1) / 2;
        return sumExpected - sum;
    }
}
