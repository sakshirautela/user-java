package com.learn.java.problemsolving;

import java.util.HashMap;
import java.util.HashSet;

public class CountUniquesInArrays {
    public static int countUniques(int[] a, int k, int l, int r) {
        // code here
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        while(r>=l){
            hs.add(r);
            r--;
        }
        System.out.println(hs);
        System.out.println(hm);
        for (int i : a) {
            if(hs.contains(i)){
                hs.remove(i);
            }
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int res = 0;
        int len=hs.size();
        for (int count : hm.keySet()) {
            if(hs.contains(count) && hm.get(count)>1){
                res+=Math.min(len,hm.get(count)-1);
                hs.remove(count);
            }else if(hm.get(count)==1){
                res++;
            }
        }
           return res;
        }
    public static void main(String agrs[]){
        System.out.println(countUniques(new int[]{2,2,2,1},1,2,3));}}