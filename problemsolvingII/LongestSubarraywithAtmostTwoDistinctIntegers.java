import java.util.HashMap;

public class LongestSubarraywithAtmostTwoDistinctIntegers {
    public static void main(String[] args) {
        System.out.println(totalElements(new int[] {2,2,1}));
    }

    public static int totalElements(int[] arr) {
        // code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        int i = 0,n = arr.length;
        int result = 0;
        for(int j=0;j<n;j++){
            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);
            while (freq.size() > 2) {
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) - 1);
                if(freq.get(arr[i])==0){
                    freq.remove(arr[i]);
                }
                i++;
            }
            result = Math.max(j - i+1, result);
        }
        return result;
    }
}