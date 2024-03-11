public class MaxSum {
        public int maxSubArray(int[] nums) {
            int maxNow = nums[0];
            int max = nums[0];
            for(int i = 1; i< nums.length; i++){
                maxNow = Math.max(nums[i]+maxNow, nums[i]);
                max = Math.max(maxNow, max);
            }
            return max;
        }
        class Solution {
            public int maxSubArray(int[] nums) {
                int max=Integer.MIN_VALUE,sum=0;
                for(int i=0;i<nums.length;i++ ) {
                    sum+=nums[i];
                    max=Math.max(max,sum);
                    if(sum<0) {
                        sum=0;
                    }
        
                }
                return max;
                
            }
        }
        class Sol {
            public int maxSubArray(int[] nums) {
                int currSum = 0, start = 0, end = 0;
                int max = Integer.MIN_VALUE;
        
                for(int i = 0; i<nums.length;i++){
                    currSum = nums[i] + currSum;
                    max = Math.max(currSum, max);
                    
                    if(currSum < 0){
                        currSum = 0;
                        start = i+1;
                    }
                    else{
                        end = i;
                    }
                }
        
                System.out.printf("start index : %d - end index : %d", start, end);
                return max;
            }
        }
    
}
