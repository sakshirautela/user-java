package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[] {}, 'e'));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (hashValue(x, s.toCharArray())) {
                li.add(i);
            }
        }
        return li;
    }

    private static boolean hashValue(char x, char[] s) {
        for (char c : s) {
            if(x==c){
                return true;
            }
        }
        return false;
    }

    public List<Integer> findWordsContaining2(String[] words, char x) {
        List<Integer> result = new ArrayList<>();        
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }      
        return result;
    }
}