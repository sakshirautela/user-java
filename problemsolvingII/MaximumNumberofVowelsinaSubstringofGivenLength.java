public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    public static int maxVowels(String s, int k) {
        int n = s.length();
        int result = 0;
        int count = 0;
        boolean[] isvowel=new boolean[n];
        for (int i = 0; i < n; i++) {
            char ch=s.charAt(i);
            if (ch=='a'||ch=='i'||ch=='o'||ch=='u'||ch=='e') {
                isvowel[i]=true;
            }
            if (i < k) {
                if(isvowel[i]){
                    count++;
                }
                result=Math.max(count,result);
            }else{
                if (isvowel[i-k]) {
                    count--;
                }
                if (isvowel[i]) {
                    count++;
                }
                result=Math.max(count,result);
            }
        }
        return result;
    }
}