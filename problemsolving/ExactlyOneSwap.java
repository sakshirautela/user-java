public class ExactlyOneSwap {
    public static void main(String[] args) {
        System.out.println(countStrings(""));
    }
    static int countStrings(String s) {
        // code here
        int n=s.length();
        long swaps=(n*(n-1))/2;
        int[] freq=new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        long duplicates=0;
        boolean hasduplicates=false;
        for (int i : freq) {
            if(i>1){
                duplicates+=(long)(i*(i-1))/2;
                hasduplicates=true;
            }
        }
        long ans=(swaps-duplicates);
        if(hasduplicates){
            ans++;
        }
        return (int)ans;
    }
}