import java.util.HashMap;

public class SubarraysWithAtMostKDistinctIntegers {
    public static void main(String[] args) {
        System.out.println(countAtMostK(new int[]{},3));
    }
    public static int countAtMostK(int arr[], int k) {
        // code here
         HashMap<Integer, Integer> freq = new HashMap<>();
        int i = 0,n = arr.length;
        int result = 0;
        for(int j=0;j<n;j++){
            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);
            while (freq.size() > k) {
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) - 1);
                if(freq.get(arr[i])==0){
                    freq.remove(arr[i]);
                }
                i++;
            }
           if(freq.size()<=k){
                result+=(j-i+1);
            }
        }
        return result;
    }
}
