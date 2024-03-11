import java.util.HashMap;
public class SubArraySumK {
    public static void main(String[] args) {
        int nums[]={10,-2,2,-20,10};
        int k=-10;
        int sum=0;
        int ans=0;
        HashMap<Integer,Integer> hm=new HashMap();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                ans+=hm.getOrDefault(sum-k,0);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        System.out.println(ans);
    }
}
