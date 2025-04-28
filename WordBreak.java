package com.learn.java.problemsolving;

import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String s, String[] wordDict) {
        HashSet<String> hs =new HashSet<>();
        for(int i=0;i<wordDict.length;i++){
            hs.add(wordDict[i]);
        }
        return helper(s, hs,new HashMap<>());
    }
    public static boolean helper(String str,HashSet<String> hs,HashMap<String,Boolean> temp){
        if(str.equals("")){
            return true;
        }
        if(!temp.containsKey(str)){
            boolean result=false;
            for(String word:hs){
                if(str.indexOf(word)==0){
                    if(str.equals(word)){
                        return true;
                    }else{
                        result=helper(str.substring(word.length()), hs,temp);
                        if(result){
                            break;
                        }
                    }
                }
            }
            temp.put(str,result);
        }
        return temp.get(str);
    }
    public boolean wordBreakOptimize(String s, String[] dictionary) {
        // code here
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Traverse through the given string
        for (int i = 1; i <= n; i++) {
            // Traverse through the dictionary words
            for (String w : dictionary) {
                // Check if the current word is present and
                // the prefix before the word is also
                // breakable
                int start = i - w.length();
                if (start >= 0 && dp[start]
                    && s.substring(start,
                                   start + w.length())
                           .equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(wordBreak("abcd",new String[]{"a","abc","cd","b"}));
    }
}