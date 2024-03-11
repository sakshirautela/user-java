import java.util.HashMap;
import java.util.Set;

class DuplicateNumber{
    public static void main(String[] args) {
        int[] nums={ 3, 1, 3, 4, 2};
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int data=0;
        for (int i: hm.keySet() )  {
            if(hm.get(i)>1){
                data=i;
            }
        }
        System.out.println(data);
    }
}
