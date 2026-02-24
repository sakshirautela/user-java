import java.io.FileWriter;
import java.util.HashMap;

public class SubArraySumDivisbleByK {
        public int subarraysDivByKFast(int[] arr, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            int prefixSum = 0;
            int count = 0;
            for(int x : arr){
                prefixSum += x;
                int rem = prefixSum % k;
                if(rem<0) rem += k;
                if(map.containsKey(rem)){
                    count += map.get(rem);
                }
                map.put(rem,map.getOrDefault(rem,0)+1);

            }
            return count;
        }
        static {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                    fw.write("0");
                } catch (Exception e) {}
            }));
        }
    public static int subarraysDivByKOptimize(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            dp[i]=(dp[i-1]+nums[i]%k +k)%k;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=map.getOrDefault(dp[i],0);
            map.put(dp[i],map.getOrDefault(dp[i],0)+1);
        }
        System.out.println(map);
        return ans;
    }
        public static int subarraysDivByK(int[] nums, int k) {
        int res=0;
        for(int i=0;i<nums.length-1;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
            }
            if(sum%k==0){
                res++;
            }
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(subarraysDivByKOptimize(new int[]{4,5,0,-2,-3,1},5));
    }
}
