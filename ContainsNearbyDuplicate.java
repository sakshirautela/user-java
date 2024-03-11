import java.util.HashMap;

public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res=false;
        HashMap<Integer,Integer> hm=new HashMap<>();
            
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                if(hm.get(nums[i])!=i && Math.abs(i-hm.get(nums[i]))<=k){
                    res=true;
                }
                else{
                    hm.put(nums[i],i);
                }
            }
            else{
                hm.put(nums[i],i);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int arr[]={1,0,1,1};
        System.out.println(containsNearbyDuplicate(arr,1));
    }
}