package com.learn.java.problemsolving;

public class InterleavingString {
    public static void main(String args[]) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int a = s1.length();
        int b = s2.length();
        int c = s3.length();
        boolean[][] dp = new boolean[a + 1][b + 1];
        dp[0][0] = true;
        for (int i = 1; i <= a; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            }else{
                break;
            }
        }
        for (int i = 1; i <= b; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i <=a;  i ++) {
            for (int j = 1; j <=b; j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        printDp(dp);
        return dp[a][b];
    }

    private static void printDp(boolean[][] dp) {
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    // public static boolean isInterleave(String s1, String s2, String s3) {
    // int x,y;
    // x=y=0;
    // for(int i=0;i<s3.length();i++){
    // if(x<s2.length() && s3.charAt(i)==s2.charAt(x)){
    // x++;
    // }
    // else if(y<s1.length() && s3.charAt(i)==s1.charAt(y)){
    // y++;
    // }else{
    // return false;
    // }
    // }
    // return true;
    // }
}