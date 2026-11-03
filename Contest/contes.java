package Contest;

import java.util.HashMap;
import java.util.HashSet;

public class contes {
    static void main() {
        //System.out.println(minQueenMoves(new int[]{},new int[]{0}));
       // System.out.println(canTransform(new int[]{1,2,3},new int[]{0,2,4}));
        System.out.println(longestSubarray(new int[]{1,-10,-21,-7}, 13));
    }
        public static int minQueenMoves(int[] source, int[] target) {
            if(source[0]==target[0] && source[1]==target[1]){
                return 0;
            }
            if(source[0]==target[0] || source[1]==target[1] || (Math.abs(source[0]-target[0]) == Math.abs(source[1]-target[1]))){
                return 0;
            }
            return 2;
        }
    public static boolean canTransform(int[] source, int[] target) {
            int n=source.length;
            int t=0;
            int s=0;
            for(int i=0;i<n;i++){
                s+=source[i];
                t+=target[i];
            }
            return s==t;
    }
    public static int longestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[] preSum = new long[n+1];
        int max=0;
        int[][]dp=new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            preSum[i+1]=preSum[i]+nums[i];
            if((preSum[i]%k+k)%k==0){
                max=i;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                long sum=preSum[i+1]-preSum[j];
                long sum2=((2L *nums[j])%k+k)%k;
                if(((sum)%k+k)%k==0){
                    max=Math.max(max,i-j+1);
                }else{
                    long mod=((sum)%k+k)%k;

//                    if(set.contains(mod)){
//                        max=Math.max(max,i-j+1);
//                    }
                }
            }
        }

        return max;

    }
        public static int longestSubarrayTLE(int[] nums, int k) {
        int n=nums.length;
        long[] preSum = new long[n+1];
        int max=0;

        for(int i=0;i<n;i++){
            preSum[i+1]=preSum[i]+nums[i];
            if((preSum[i]%k+k)%k==0){
                max=i;
            }
        }

        for(int i=0;i<n;i++){
            HashSet<Long> set=new HashSet<>();

            for(int j=i;j>=0;j--){
                long sum=preSum[i+1]-preSum[j];
                long sum2=((2L *nums[j])%k+k)%k;

                set.add(sum2);

                if(((sum)%k+k)%k==0){
                    max=Math.max(max,i-j+1);
                }else{
                    long mod=((sum)%k+k)%k;

                    if(set.contains(mod)){
                        max=Math.max(max,i-j+1);
                    }
                }
            }
        }

        return max;
    }

}
