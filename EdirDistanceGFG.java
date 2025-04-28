package com.learn.java.problemsolving;

public class EdirDistanceGFG {
    public static void main(String[] args) {
        System.out.println(editDistance2("geek", "geesk"));
    }

    public static int editDistance2(String s1, String s2) {
        // Code here
        return editDistanceHelper(s1, s2, 0, 0);
    }

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<m+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int add=dp[i][j-1]+1;
                    int delete=dp[i-1][j]+1;
                    int replace=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(add,Math.min(delete,replace));
                }
            }
        }
        return dp[n][m];
    }

    private static int editDistanceHelper(String s, String t, int i, int j) {
        if (i == s.length()) {
            return t.length() - j;
        }
        if (j == t.length()) {
            return s.length() - i;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return editDistanceHelper(s, t, i + 1, j + 1);
        } else {
            return Math.min(editDistanceHelper(s, t, i, j + 1),
                    Math.min(editDistanceHelper(s, t, i - 1, j + 1), editDistanceHelper(s, t, i + 1, j + 1))) + 1;
        }
    }
    // A Naive recursive Java program to find minimum number
    // of operations to convert s1 to s2.

    // Recursive function to find number of operations
    // needed to convert s1 into s2.
    static int editDistRec(String s1, String s2, int m, int n) {

        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same, nothing
        // much to do. Get the count for
        // remaining strings.
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistRec(s1, s2, m - 1, n - 1);

        // If last characters are not same, consider all three
        // operations on last character of first string,
        // recursively compute minimum cost for all three
        // operations and take minimum of three values.
        return 1 + Math.min(
                Math.min(editDistRec(s1, s2, m, n - 1),
                        editDistRec(s1, s2, m - 1, n)),
                editDistRec(s1, s2, m - 1, n - 1));
    }

    // Wrapper function to initiate the recursive calculation
    static int editDistance3(String s1, String s2) {
        return editDistRec(s1, s2, s1.length(), s2.length());
    }

}