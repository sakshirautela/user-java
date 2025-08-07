public class CountUniqueVowelString {
    public static void main(String[] args) {
        System.out.println(vowelCount("aabceffghii"));
    }

    public static int vowelCount(String s) {
        // code here
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int unique=0;
        int result=1;
        if(freq[0]>=1){
            unique++;
            result*=unique*freq[0];
        }
        if(freq[4]>=1){
            unique++;
            result*=unique*freq[4];
        }
        if(freq[8]>=1){
            unique++;
            result*=unique*freq[8];
        }
        if(freq[14]>=1){
            unique++;
            result*=unique*freq[14];
        }
        if(freq[20]>=1){
            unique++;
            result*=unique*freq[20];
        }
            return (unique==0)?0:result;
    }
}
