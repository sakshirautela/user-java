import java.util.HashMap;

public class LongestSubstringwithKUniques {
    public static void main(String[] args) {
        System.out.println(longestKSubstr("",4));
    }
    public static int longestKSubstr(String s, int k) {
        // code here
         HashMap<Character, Integer> freq = new HashMap<>();
         char[] arr=s.toCharArray();
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
            if(freq.size()==k){
                result = Math.max(j - i+1, result);
            }
        }
        return result;
    }
}