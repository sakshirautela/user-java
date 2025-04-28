package com.learn.java.problemsolving;

public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("123"));      // true
        System.out.println(isNumber("123.45"));   // true
        System.out.println(isNumber("123e45"));   // true
        System.out.println(isNumber("1.2e3"));    // true
        System.out.println(isNumber("-123.45e+67"));// true
        System.out.println(isNumber("1a2"));      // false
        System.out.println(isNumber("e"));        // false
        System.out.println(isNumber(" "));        // false
    }

    public static boolean isNumber(String s) {
        s = s.trim(); // remove leading/trailing whitespaces
        if (s.isEmpty()) return false; // empty string is not a valid number

        int idx = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;
        boolean hasDot = false, hasE = false;

        for (int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '.') {
                // If there's already a dot or 'e'/'E' before, it's invalid
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (ch == 'e' || ch == 'E') {
                // 'e'/'E' can appear only once, and must be followed by a number
                if (hasE || i == 0 || i == s.length() - 1) return false;
                hasE = true;
            } else if (ch == '+' || ch == '-') {
                // '+'/'-' can only appear after 'e'/'E'
                if (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (!Character.isDigit(ch)) {
                // If the character is not a digit, return false
                return false;
            }
        }

        return true;
    }
}
