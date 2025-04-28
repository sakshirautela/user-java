package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.TreeMap;
public class LongestBoundedDifferenceSubarray {
    public static void main(String[] args) {
        
    }
    public static ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        int maxLen = 0;
        int beginning = 0;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int start = 0, end = 0;
        for (; end < n; end++) {
            window.put(arr[end], window.getOrDefault(arr[end], 0) + 1);
            int minimum = window.firstKey();
            int maximum = window.lastKey();
            if (maximum - minimum <= x) {
                if (maxLen < end - start + 1) {
                    maxLen = end - start + 1;
                    beginning = start;
                }
            }
            else {
                while (start < end) {
                    window.put(arr[start], window.get(arr[start]) - 1);
                    if (window.get(arr[start]) == 0) {
                        window.remove(arr[start]);
                    }
                    start++;
                    minimum = window.firstKey();
                    maximum = window.lastKey();
                    if (maximum - minimum <= x)
                        break;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = beginning; i < beginning + maxLen; i++)
            res.add(arr[i]);
            
        return res;
    }
}
