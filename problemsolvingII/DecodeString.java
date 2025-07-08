import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("100[l]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k*10+(ch - '0'); 
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int repeat = countStack.pop();
                while (repeat-- > 0) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
    public String decodeStringFast(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // It's a number
                currentNum = currentNum * 10 + (c - '0'); // Handles multiple digit numbers
            } else if (c == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                // Reset everything for the new calculation inside nested [
                currentString = new StringBuilder();
                currentNum = 0;
            } else if (c == ']') {
                // A loop has been closed. Pop and calculate strings to attach
                int repeatTimes = countStack.pop();
                StringBuilder stringToAttach = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    stringToAttach.append(currentString);
                }

                currentString = stringToAttach; // Re-assigns newly formed string for next iterations.
            } else {
                // It's an alphabet
                currentString.append(c);
            }
        }

        return currentString.toString(); // Return the resultant final string.
    }

// TC and SC: O(N)
}