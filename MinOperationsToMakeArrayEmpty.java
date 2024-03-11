import java.util.Arrays;
import java.util.HashMap;

public class MinOperationsToMakeArrayEmpty {
    public static int minOperations(int[] nums) {
        int res=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int i:hm.keySet()){
            if(hm.get(i)<=1){
                return -1;
            }else if(hm.get(i)%3==1){
                res+=(hm.get(i)/3)-1;
                res+=2;
            }else{
                res+=hm.get(i)/3;
                res+=(hm.get(i)%3)/2;
            }
        }
        return res;
    }
    public static int minOperations2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int idx=0;
        while(idx<nums.length){
            int d=idx;
            while (d<nums.length && nums[d]==nums[idx]) {
                d++;
            }
            int count=d-idx;
            if(count==1){
                return -1;
            }
            else if(count%3==0){
                ans+=count/3;
            }else{
                ans+=(count/3)-1;
                ans+=2;
            }
            idx=d;
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(minOperations2(new int[]{2,2,2,3,4,4,3,3,2}));
    }
}