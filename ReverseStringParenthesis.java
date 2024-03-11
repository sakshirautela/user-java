import java.util.Stack;

public class ReverseStringParenthesis {
    public static void main(String[] args) {
        String str = "ta()usw((((a))))";
        System.out.println(reverseParentheses(str));
    }

    public static String reverseParentheses(String s) {
        String res = s;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                String temp="";
                int n=stack.pop();
                for (int idx = n+1; idx <i; idx++) {
                        temp = s.charAt(idx) + temp;
                }
                res = res.substring(0,n ) + temp + res.substring(i + 1, s.length());
            }
        }
        return res;
    }
}
