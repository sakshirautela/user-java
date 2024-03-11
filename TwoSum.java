import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        public static void main(String args[]) {
            int[] nums= {3,2,4};
            int target=6;
            int sum=0;
            int[] result= new int[2];
            int n=nums.length;
            //Map<Integer, Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                // if (map.containsKey(nums[i])){
                //     result[0]=i;
                //     result[1]=map.get(nums[i]);
                // }
                // else{
                //     map.put(target - nums[i],i);
                // }
                for(int j=i+1;j<nums.length;j++){
                    sum=nums[i]+nums[j];
                    if(sum==target){
                        result[0]=i;
                        result[1]=j;
                    }
                }
            }
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
    }
   
