package com.learn.java.problemsolving;

public class NonRepeatingCharactersGFG {
    public static void main(String[] args){
        System.out.println(nonRepeatingChar("aabbccc"));
    }
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        char ch='$';
        char[] freq=new char[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c:s.toCharArray()){
            if(freq[c-'a']==1){
                return c;
            }
        }
        return ch;
    }
}