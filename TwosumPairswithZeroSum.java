package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class TwosumPairswithZeroSum {
    public static void main(String[] args) {
        System.out.println(getPairs(new int[] {}));
    }

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        HashSet<ArrayList<Integer>> uniquePairs = new HashSet<>();

        for (int num : arr) {
            if (set.contains(-num)) {
                ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(num, -num));
                Collections.sort(pair);
                uniquePairs.add(pair);
            }
            set.add(num);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(uniquePairs);
        ans.sort(Comparator.comparingInt(a -> a.get(0))); 
        return ans;
    }
}
