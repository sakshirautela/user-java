package com.learn.java.problemsolving;

import java.util.*;

public class FindMedianinaStream {
    public static void main(String[] args) {
        System.out.println(getMedian(new int[] {}));
    }

    private static void insertIntoHeaps(int num, PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        if (max.isEmpty() || num <= max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        if (max.size() > min.size() + 1) {
            min.add(max.poll());
        } else if (max.size() < min.size()) {
            max.add(min.poll());
        }
    }

    public static ArrayList<Double> getMedian(int[] arr) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        ArrayList<Double> ans = new ArrayList<>();

        for (int it : arr) {
            insertIntoHeaps(it, min, max);

            double mid;
            if (min.size() == max.size()) {
                mid = (min.peek() + max.peek()) / 2.0;
            } else {
                mid = max.peek();
            }

            ans.add(mid);
        }

        return ans;
    }
}