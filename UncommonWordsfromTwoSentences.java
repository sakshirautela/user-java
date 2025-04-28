package com.learn.java.problemsolving;

import java.util.*;
public class UncommonWordsfromTwoSentences {
    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] str1=s1.split(" ");
        String[] str2=s2.split(" ");
        HashMap<String,Integer> freq=new HashMap<String,Integer>();
        for(String s:str1){
            freq.put(s,freq.getOrDefault(s,0)+1);
        }
        for(String s:str2){
            freq.put(s,freq.getOrDefault(s,0)+1);
        }
        ArrayList<String> result=new ArrayList<String>();
        for(String s:freq.keySet()){
            if(freq.get(s)<2){
                result.add(s);
            }
        }
        return result.toArray(new String[0]);
    }
    public static void main(String args[]) {
        System.out.println(uncommonFromSentences("abss","abss"));
    }
}