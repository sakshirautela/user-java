public class WaysToSplitArraysinto3subarray {
    public static int waysToSplit(int[] nums) {
        int count=0;
        int sum[]=new int[nums.length];
        sum[0]=nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = nums[i]+sum[i-1];
        }
        for (int i = 0; i < nums.length-2; i++) {
            int first =sum[i];
            int f=-1;
            int second =sum[i];
            int s=-1;
            int idx=i+1;
            while(idx<nums.length && (sum[i]>=first && sum[idx]-sum[i]>=nums[i]) ) {
                first = sum[idx];
                f=idx;
                idx++;
            }
            while(idx<nums.length && (first>=second || sum[idx]-second>=nums[i])) {
                second = sum[idx];
                s=idx;
                idx++;
            }
            if(sum[i]<first && first<second){
                count=Math.max(count,idx-i-1);
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(waysToSplit(new int[]{ 1, 2, 2 ,2,5,0}));
    }
}