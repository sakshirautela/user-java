
public class ReverseStringNotWords {
    // Function to reverse words in a given string.
    static String reverseWords(String str) {
        // code here
        System.out.println(str);
        String[] s=str.split("\\.");
        int n=s.length;
        String res=s[n-1]+".";
        for (int i = n-2; i>=1;i--) {
            res+=s[i]+".";
        }
        return res+s[0];
    }
    public static void main(String args[]){
        System.out.println(reverseWords("i.like.this.program.very.much"));
    }
}
