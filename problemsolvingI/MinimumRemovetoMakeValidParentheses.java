
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        boolean valid[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    valid[i] = true;
                } else {
                    st.pop();
                }
            }
        }
        while (!st.isEmpty()) {
            valid[st.pop()] = true;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!valid[i])
                str.append(s.charAt(i));

        }
        return str.toString();
    }

    public static String minRemoveToMakeValid2(String s) {
        // Initialize pointers for the start and end of the string
        String result;

        // Convert input string to character array for easier manipulation
        char[] arr = s.toCharArray();

        // Counter for open parentheses
        int openParenthesesCount = 0;

        // First pass: mark excess closing parentheses with '*'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                openParenthesesCount++;
            else if (arr[i] == ')') {
                if (openParenthesesCount == 0)
                    arr[i] = '*'; // Mark excess closing parentheses
                else
                    openParenthesesCount--;
            }
        }

        // Second pass: mark excess opening parentheses from the end
        for (int i = arr.length - 1; i >= 0; i--) {
            if (openParenthesesCount > 0 && arr[i] == '(') {
                arr[i] = '*'; // Mark excess opening parentheses
                openParenthesesCount--;
            }
        }

        // Filter out marked characters and store the result in the character array
        int p = 0; // Pointer for updating the character array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*')
                arr[p++] = arr[i];
        }

        // Construct the result string from the filtered character array
        result = new String(arr).substring(0, p);

        return result;
    }
}
