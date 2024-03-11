import java.util.Stack;

public class backSpaceCompare {
    public static void main(String[] args) {
        String s = "", t = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length() || i < t.length(); i++) {
            if (s.charAt(i) == '#') {
                stack.pop();
            }
            if (s.charAt(i) == '#') {
                stack.pop();
            }
            stack.push(s.charAt(i));
            stack.push(t.charAt(i));
        }
    }
}
