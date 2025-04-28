package com.learn.java.problemsolving;

public class MovePiecestoObtainaString {

    public boolean canChange(String start, String target) {
        int startLength = start.length();
        // Pointers for start string and target string
        int startIndex = 0, targetIndex = 0;

        while (startIndex < startLength || targetIndex < startLength) {
            // Skip underscores in start
            while (
                startIndex < startLength && start.charAt(startIndex) == '_'
            ) {
                startIndex++;
            }
            // Skip underscores in target
            while (
                targetIndex < startLength && target.charAt(targetIndex) == '_'
            ) {
                targetIndex++;
            }
            // If one string is exhausted, both should be exhausted
            if (startIndex == startLength || targetIndex == startLength) {
                return startIndex == startLength && targetIndex == startLength;
            }

            // Check if the pieces match and follow movement rules
            if (
                start.charAt(startIndex) != target.charAt(targetIndex) ||
                (start.charAt(startIndex) == 'L' && startIndex < targetIndex) ||
                (start.charAt(startIndex) == 'R' && startIndex > targetIndex)
            ) return false;

            startIndex++;
            targetIndex++;
        }

        // If all conditions are satisfied, return true
        return true;
    }
    public boolean canChange2(String start, String target) {
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        int n = s.length;
        int i=0, j=0;

        while(i<=n && j<=n){

            while(i<n && s[i] == '_') i++;
            while(j<n && t[j] == '_') j++;

            if(i == n || j==n) return i==n && j==n;

            if(s[i]!=t[j]) return false;
            if(s[i] == 'L' && i<j) return false;
            else if(s[i] == 'R' && i>j) return false;

            i++;
            j++;
        }

        return true;
    }
    public static void main(String[] rags){
        System.out.println();
    }
}