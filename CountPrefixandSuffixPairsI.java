public class CountPrefixandSuffixPairsI {
    public static void main(String args[]){
        System.out.println(countPrefixSuffixPairs(new String[]{}));
    }
    public static int countPrefixSuffixPairs(String[] words) {
        int result=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    result++;
                }
            }
        }
        return result;
    }
    public static boolean isPrefixAndSuffix(String s1,String s2){
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        int n=s2.length()-1;
        for(int i=s1.length()-1;i>=0;i--){
            if(s1.charAt(i)!=s2.charAt(n)){
                return false;
            }
            n--;
        }
        return true;
    }
}