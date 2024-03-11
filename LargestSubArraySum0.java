import java.util.HashMap;

public class LargestSubArraySum0{
    public static void main(String[] args) {
        int nums[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        int len=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(hm.containsKey(sum)){
                len=i-hm.get(sum);
            }
            else{
                hm.put(sum, i);
            }
        }
        System.out.println(len);
    }
}