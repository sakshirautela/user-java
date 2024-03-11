import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
class TopKFrequentSol {
    public static void topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        System.out.println(hm);
        int[] ans=new int[k];
        while(k>0){
            int max=0;
            int idx=0;
            for(int i=0;i<nums.length;i++){
                if(hm.containsKey(nums[i])){
                    if(hm.get(nums[i])>max){
                        max=hm.get(nums[i]);
                        idx=i;
                    }
                }
            }
            hm.remove(nums[idx]);
            ans[k-1]=nums[idx];
            k--;
        }
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
        // return ans;
    }
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> tm=new HashMap<Integer,Integer>();
        for(int t:nums){
            if(tm.containsKey(t)){
                tm.put(t,tm.get(t)+1);
            }
            else{
                tm.put(t,1);
            }
        }
        tm.values();
        int n=nums.length;
        int ans[]=new int[n];
        for(int num:tm.keySet()){
            n--;
            ans[n]=num;
            System.out.print(ans[n]+" ");
        }
        int result[]=Arrays.copyOfRange(ans,0,k);
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums={ 4, 1, -1, 2, -1, 2, 3};
        int result[]=topKFrequent2(nums,2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}