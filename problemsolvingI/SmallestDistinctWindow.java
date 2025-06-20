import java.util.HashMap;

public class SmallestDistinctWindow {
    public static void main(String[] args) {
        System.out.println(findSubString("aabcbcdbca"));
    }

    public static int findSubString(String str) {
        // code here
        int n = str.length();
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> sub = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        int result=n;
        int unique = freq.size();
        int j=0;
        for (int i = 0; i < n; i++) {
            char ch=str.charAt(i);
            sub.put(ch,sub.getOrDefault(ch,0)+1);
            if(sub.size()==unique){
                while (j<n && sub.get(str.charAt(j))>1){
                    int f=sub.get(str.charAt(j));
                    sub.put(str.charAt(j),f-1);
                    j++;
                }
                result=Math.min(result,i-j+1);
            }
        }
        return result;
    }
}