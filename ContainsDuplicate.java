import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        boolean bool = false;
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length-1;i++){
        // if(nums[i]==nums[i+1]){
        // bool=true;
        // break;
        // }
        // }
        // return bool;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(nums[i])) {
             
            map.put(i, nums[i]);
            bool = true;
            break;
            }
            map.put(i, nums[i]);

        }
        //retrun bool;
        System.out.println(bool);
        System.out.print(map);

    }
}