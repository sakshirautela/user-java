package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimizeCost {
    public static long minCost(int n, int[] a, int[] b) {
        // code here
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> swap_a = new ArrayList<>();
        List<Integer> swap_b = new ArrayList<>();
        
        // Counting the elements
        for (int i = 0; i < n; i++) {
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
            count.put(b[i], count.getOrDefault(b[i], 0) - 1);
        }
        
        // Check if every count value is even
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return -1;
            }
        }
        
        // Populate swap_a and swap_b
        for (int i = 0; i < n; i++) {
            if (count.get(a[i]) > 0) {
                swap_a.add(a[i]);
                count.put(a[i], count.get(a[i]) - 2);
            }
            if (count.get(b[i]) < 0) {
                swap_b.add(b[i]);
                count.put(b[i], count.get(b[i]) + 2);
            }
        }
        
        // Sort swap_a in ascending order and swap_b in descending order
        Collections.sort(swap_a);
        swap_b.sort(Collections.reverseOrder());
        
        long cost = 0;
        int m = swap_a.size();
        
        for (int i = 0; i < m; i++) {
            cost += Math.min(swap_a.get(i), swap_b.get(i));
        }
        
        return cost;
    }
    public static void main(String args[]) {
        System.out.println(minCost(4,new int[]{1,2,2,2},new int[]{1,2,4,4}));
    }
}