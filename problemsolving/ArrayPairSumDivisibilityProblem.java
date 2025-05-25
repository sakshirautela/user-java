import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayPairSumDivisibilityProblem {
    public static void main(String[] args) {
        System.out.println(canPair(new ArrayList<>(),5));
    }
    public static boolean canPair(List<Integer> arr, int k) {
         // code here.
        int n=arr.size();
        if(n%2!=0){
            return false;
        }
        if(k==1){
            return true;
        }
        int sum=0;
        HashMap<Integer,Integer> freq=new HashMap<>();
        for (int i : arr) {
            sum+=i;
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        int target=(sum/n)*2;
        for(int i:arr){
            if(!freq.containsKey(Math.abs(target-i))){
                return false;
            }
        }
        return true;
    }
}
