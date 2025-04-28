package com.learn.java.problemsolving;

public class MakeStringaSubsequenceUsingCyclicIncrements {
    public static boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0, m = str1.length(), n = str2.length();
        while (i < m) {
            char ch = (str1.charAt(i) == 'z') ? 'a' : ((char) (str1.charAt(i) + 1));
            if (str1.charAt(i) == str2.charAt(j) || ch == str2.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return true;
                }
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean canMakeSubsequence2(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < n1 && ptr2 < n2) {
            char sch = str1.charAt(ptr1);
            char tch = str2.charAt(ptr2);
            if (sch != tch) {
                if (sch + 1 == tch || sch - 25 == tch) {
                    ptr1++;
                    ptr2++;
                } else {
                    ptr1++;
                }
            }

            else {
                ptr1++;
                ptr2++;
            }

            if (ptr1 == n1 && ptr2 != n2)
                return false;

        }
        return true;

    }

    public static void main(String args[]) {
        System.out.println(canMakeSubsequence("ab", "d"));
    }
}