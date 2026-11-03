import java.util.Stack;

public class LongestValidParenthesesLeetcode {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("())"));
    }

    public static int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                st.pop();
                if (!st.isEmpty()) {
                    result = Math.max(result, i - st.peek());
                } else {
                    st.push(i);
                }

            }
        }
        return result;
    }

    public static int longestValidParentheses2(String s) {
        int n = s.length();
        int prev = -1;
        int result = 0;
        int c = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                prev = c;
                c=i;
            }else{
                if(prev!=-2){
                    result=Math.max(result,i - prev);
                }else{
                    prev = c;
                    c=i;
                }
            }
        }
        return result;
    }
}
