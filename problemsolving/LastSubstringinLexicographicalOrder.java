public class LastSubstringinLexicographicalOrder {
    public static void main(String[] args) {
        System.out.println(lastSubstring(""));
    }
    public static String lastSubstring(String s) {
        int left=0,right=1,similar=0;
        int n=s.length();
        while (right+similar<n) {
            if(s.charAt(left+similar)==s.charAt(right+similar)){
                similar++;
            }else if(s.charAt(left+similar)<s.charAt(right+similar)){
                left=left+similar+1;
                similar=0;
                if(left>=right){
                    right=left+1;
                }
            }else{
                right=right+similar+1;
                similar=0;
            }
        }
        return s.substring(left);
    }
    public String lastSubstring2(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int i = 0;
        int j = 1;
        int k = 0;
        while(j + k < n) {
            if(ch[i + k] == ch[j + k]) k++;
            else if(ch[i + k] > ch[j + k]) {
                j = j + k + 1;
                k = 0;
            } else {
                i = Math.max(i + k, j);
                j = i + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
    public static String lastSubstringTLE(String s) {
        int ch=-1;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            if(ch<s.charAt(i)-'a'){
                ch=s.charAt(i)-'a';
            }
        }
        String res="";
        for (int i = 0; i < n; i++) {
            if(ch==s.charAt(i)-'a'){
                String sub = s.substring(i);
            if (sub.compareTo(res) > 0) {
                res = sub;
            }
            }
        }
        return res;
    }
}