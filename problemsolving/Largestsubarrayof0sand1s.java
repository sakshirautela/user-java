
import java.util.HashMap;

public class Largestsubarrayof0sand1s {
    public static void main(String[] args) {
        System.out.println(maxLen(new int[] {}));
    }

    public static int maxLen(int[] arr) {
        // Your code here
        int n = arr.length;
        int preSum=0;
        int result=0;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            preSum+=(arr[i]==0)?-1:1;
            if(preSum==0){
                result=i+1;
            }
            if (hm.containsKey(preSum)){
                result=Math.max(result,i-hm.get(preSum));
            }else{
                hm.put(preSum,i);
            }
        }
        return result;
    }
}
