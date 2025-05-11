import java.util.HashMap;

public class LongestSubarraywithMajorityGreaterthanK {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[] {1, 2, 3, 4, 1}, 2));
    }

    static int longestSubarray(int[] arr, int k) {
        // Code Here
        int result = 0;
        int n = arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum =0;
        hm.put(0,-1);
        for (int i = 0; i < n; i++) {
            sum+=((k <arr[i]) ? 1 : -1);
            if(sum>0){
                result=i+1;
            }else{
                int need=sum-1;
                if(hm.containsKey(need)){
                    result=Math.max(result,i-hm.get(need));
                }
            }
            if(!hm.containsKey(sum)){

                hm.put(sum,i);
            }
        }
        return result;
    }
    static int longestSubarray2(int[] arr, int k) {
 int result = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cnt=0;
            for (int j = i; j <n; j++) {
                if(arr[j]>k){
                    cnt++;
                }else{
                    cnt--;
                }
                if(cnt>0 && result<j-i+1){
                    result=j-i+1;
                }
            }
        }
        return result;
    }
}