public class LongestSubsequenceRepeatedKTimes {
    public static void main(String[] args) {
        System.out.println(longestSubsequenceRepeatedK("",4));
    }
    public static String longestSubsequenceRepeatedK(String s, int k) {
        int n=s.length();
        for(int i=0;i<=n/k;i++){
            String[] str={""};
            getSubstring(i,n,0,s,k,"",str);
        }
    }
    private static void getSubstring(int i, int n,int idx, String s, int k,String sub,String[] str) {
        if(idx==n/k){
            str[0]=sub;
            return ;
        }
        getSubstring(i+1, n, idx, s, k, sub);
        getSubstring(i+1, n, idx+1, s, k, sub+s.charAt(i));
    }
}