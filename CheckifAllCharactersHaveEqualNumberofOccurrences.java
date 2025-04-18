public class CheckifAllCharactersHaveEqualNumberofOccurrences {
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual(""));
    }
    public static boolean areOccurrencesEqual(String s) {
        int[] freq=new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        int rep=freq[s.charAt(0)-'a'];
        for (int i : freq) {
            if(i%rep!=0){
                return false;
            }
        }
        return true;
    }
        static{
            for(int i=0; i<=100; i++){
                areOccurrencesEqual(new String());
            }
        }
    
        public static boolean areOccurrencesEqual2(String s) {
            int ans[]=new int[26];
            int x=0;
            if(s.length()==1) return true;
            for(int i=0;i<s.length();i++)
            {
                ans[s.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                if(ans[i]!=0)
                {
                x=ans[i];
                break;
                }
    
            }
            for(int i=0;i<26;i++)
            {
                if(ans[i]!=0&&ans[i]!=x) return false;
    
            }
            return true;
        }
}