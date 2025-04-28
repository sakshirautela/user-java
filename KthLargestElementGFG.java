package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElementGFG {
    public static void main(String[] args) {
        System.out.println(kLargest(new int[]{},3));
    }
    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        ArrayList<Integer> al=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:arr){
            pq.add(i);
        }
        while(!pq.isEmpty() && k>0){
            al.add(pq.remove());
            k--;
        }
        return al;
    }
}
