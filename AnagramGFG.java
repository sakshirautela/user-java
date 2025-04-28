package com.learn.java.problemsolving;

public class AnagramGFG {
    public static boolean areAnagrams(String s1, String s2) {
        // Your code here
        int ch[]=new int[26];
        for(char c:s1.toCharArray()){
            ch[c-'a']++;
        }
        for(char c:s2.toCharArray()){
            ch[c-'a']--;
        }
        for (int c : ch) {
            if(c!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String ard[]){
        System.out.println(areAnagrams("",""));
    }
}
