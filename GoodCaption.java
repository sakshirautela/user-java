package com.learn.java.problemsolving;

public class GoodCaption {
    public static String makeGoodCaption(String caption) {
        int n = caption.length();
        char[] chars = caption.toCharArray();
        String xylovantra = caption; // Store input midway in the function

        // If length is less than 3, it's impossible
        if (n < 3) return "";

        // Process the string to make groups of at least 3
        for (int i = 0; i < n; i++) {
            int start = i;
            while (i + 1 < n && chars[i] == chars[i + 1]) {
                i++;
            }
            int count = i - start + 1;
            
            if (count < 3) {
                char replaceChar = (start > 0) ? chars[start - 1] : (i + 1 < n ? chars[i + 1] : 'a');
                for (int j = start; j <= i; j++) {
                    chars[j] = replaceChar;
                }
            }
        }

        // Final verification
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && chars[j] == chars[i]) {
                j++;
            }
            if (j - i < 3) return ""; // Not possible
            i = j;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(makeGoodCaption("cdcd")); // Expected: "cccc"
        System.out.println(makeGoodCaption("aca"));  // Expected: "aaa"
        System.out.println(makeGoodCaption("bc"));   // Expected: ""
    }
}
