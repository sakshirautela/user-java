import java.util.*;
public class CountNicePairs {
    public static int countNicePairs(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if(hm.containsKey(i-reverseNum(i))){
                count+=hm.get(i-reverseNum(i));
            }
            hm.put(i-reverseNum(i),hm.getOrDefault(i-reverseNum(i),0)+1);
        }
        return count;
    }
    public static int reverseNum(int n){
        int res=0;
        while(n>0){
            int rem=n%10;
            res=res*10+rem;
            n/=10;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(countNicePairs(new int[]{ 13, 10, 35 ,24,76}));
    }
}