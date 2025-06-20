
import java.util.Stack;

public class CheckIfaParenthesesStringCanBeValid {
    public static void main(String[] args) {
        System.out.println(canBeValid("", ""));
    }

    public static boolean canBeValid(String s, String locked) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }
        while (!openBrackets.empty() &&
                !unlocked.empty() &&
                openBrackets.peek() < unlocked.peek()) {
            openBrackets.pop();
            unlocked.pop();
        }
        if (!openBrackets.empty()) {
            return false;
        }
        return true;
    }

    public boolean canBeValid2(String s, String locked) {
        int length = s.length();

        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }
        int openBrackets = 0;
        int unlocked = 0;

        // Iterate through the string to handle '(' and ')'.
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                openBrackets++;
            } else if (s.charAt(i) == ')') {
                if (openBrackets > 0) {
                    openBrackets--;
                } else if (unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }

        // Match remaining open brackets with unlocked characters.
        int balance = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                balance--;
                unlocked--;
            } else if (s.charAt(i) == '(') {
                balance++;
                openBrackets--;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance > 0) {
                return false;
            }
            if (unlocked == 0 && openBrackets == 0) {
                break;
            }
        }

        if (openBrackets > 0) {
            return false;
        }

        return true;
    }

    public boolean canBeValid3(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    lower++;
                    upper++;
                } else {
                    lower--;
                    upper--;
                }
            } else {
                upper++;
                lower--;
            }
            if (lower < 0) {
                lower += 2;
            }
            if (upper < 0) {
                return false;
            }
        }
        return lower == 0;
    }
}
