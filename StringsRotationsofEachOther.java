package com.learn.java.problemsolving;

public class StringsRotationsofEachOther {
    public static boolean areRotations(String s1, String s2) {
        // Your code here
            s1 = s1 + s1;
        return (s1.indexOf(s2)!=-1)?true:false;
    }

    public static void main(String args[]) {
        System.out.println(areRotations("abcd", "ac"));
    }
}
