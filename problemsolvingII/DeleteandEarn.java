import java.util.HashMap;

public class DeleteandEarn {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{}));
    }
    public static int deleteAndEarn(int[] nums) {
int n=nums.length;
if(n==0){
    return 0;
}
HashMap<Integer,Integer> map=new HashMap<>();
int sum=0;
int maxel=0;
for (int i:nums){
    sum+=i;
    maxel=Math.max(maxel,i);
    map.put(i,map.getOrDefault(i,0)+1);
}
int[] dp=new int[maxel+1];
dp[1]= map.getOrDefault(1, 0);
        for (int i = 2; i <=maxel ; i++) {
            int curr=i*map.getOrDefault(i,0);
            dp[i]=Math.max(dp[i-1],dp[i-2]+curr);
        }
        return  dp[maxel];
    }
    public int deleteAndEarn2(int[] nums) {
        int x=nums.length;
        if(x==1) return nums[0];
        int n=0;
        for(int i:nums){
            if(i>n) n=i;
        }
        int[] arr =new int[n+1];
        for(int i:nums){
            arr[i]+=i;
        }
        int[] res =new int[n+1];
        res[0]=arr[0];
        res[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<=n;i++){
            res[i]=Math.max(arr[i]+res[i-2],res[i-1]);
        }
        return res[n];
    }
}