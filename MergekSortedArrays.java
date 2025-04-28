package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergekSortedArrays {
    public static void main(String[] args) {
        System.out.println(mergeKArrays(new int[][] {{}}, 3));
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i[] : arr) {
            for (int j : i) {
                pq.add(j);
            }
        }
        while (!pq.isEmpty()) {
            al.add(pq.remove());
        }
        return al;
    }
}
