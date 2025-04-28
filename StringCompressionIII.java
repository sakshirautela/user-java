package com.learn.java.problemsolving;

public class StringCompressionIII {
    public static String compressedString(String word) {
        int i = 0;
        StringBuilder str = new StringBuilder();
        while (i < word.length()) {
            int len = 1;
            while (i + len < word.length() && word.charAt(i) == word.charAt(i + len)) {
                len++;
                if (len == 9) {
                    break;
                }
            }
            str.append(Integer.toString(len));
            str.append(word.charAt(i));
            i += len;
        }
        return str.toString();
    }

    public String compressedString2(String word) {
        StringBuilder sb = new StringBuilder();
        int count = 0, j = 0;
        for (int i = 0; i < word.length(); ++i) {
            j = i;
            char c = word.charAt(i);
            while (j < word.length() && word.charAt(j) == c) {
                ++count;
                ++j;
            }
            while (count > 9) {
                sb.append('9');
                sb.append(c);
                count -= 9;

            }
            sb.append((char) (count + '0'));
            sb.append(c);
            count = 0;
            i = j - 1;

        }
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(compressedString("abcde"));
    }
}