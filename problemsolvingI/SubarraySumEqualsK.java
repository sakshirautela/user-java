
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySumTwoPointsers(int[] nums, int s) {
        int n=nums.length;
        int[] prefixSum=new int[n];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=(prefixSum[i-1]+nums[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            ans+=map.getOrDefault(prefixSum[i]-s,0);
            map.put(prefixSum[i],map.getOrDefault(prefixSum[i],0)+1);
        }
        return ans;
    }
        public static int subarraySum(int[] nums, int s) {
        int result=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                if(sum==s){
                    result++;
                }
            }
        }
        return result;
    }
    //optimize
    public static int subarraySum2(int[] nums, int k) {
        int result=0;
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i]=nums[i]+prefix[i-1];
            if(prefix[i]==k){
                result++;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0; j--) {
                if(prefix[i]-prefix[j]==k){
                    result++;
                }
            }
        }
        return result;
    }
    public int subarraySum3(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < sum.length; i++) {
            res += map.getOrDefault(sum[i] - k, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(subarraySumTwoPointsers(new int[]{1,1,1},2));
    }

}
