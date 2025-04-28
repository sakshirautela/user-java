package com.learn.java.problemsolving;

import java.util.HashMap;

public class BookReorderingGFG {
    public static void main(String[] args) {
        System.out.println(rearrange(new int[]{},new int[]{}));
    }
    public static int rearrange(int[] pages, int[] shelf) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=pages.length;
        int res=0;
        for(int i=0;i<n;i++){
            if(hm.containsKey(shelf[i])){
                if(pages[i]>hm.get(shelf[i])){
                    res+=hm.get(shelf[i]);
                    hm.put(shelf[i],pages[i]);
                }else{
                    res+=pages[i];
                }
            }else{
                hm.put(shelf[i],pages[i]);
            }
        }
        return res;
        
    }
}