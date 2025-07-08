import java.util.Stack;

public class LexicographicallyLargestStringAfterKDeletions {
    public static void main(String[] args) {
        System.out.println(maxSubseq("zrptllivngoi", 11));
    }
    public static String maxSubseq(String s, int k) {
        // code here
        int n=s.length();
        char[] ch=s.toCharArray();
        StringBuilder sb =new StringBuilder();
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < n; i++) {
            char c=ch[i];
            while (!st.isEmpty() && ch[st.peek()]<c && k>0) {
                st.pop();
                k--;
            }
            st.push(i);
        }
        while (k>0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        while (!st.isEmpty()) {
            sb.append(ch[st.pop()]);
        }
        return sb.reverse().toString();
    }
}