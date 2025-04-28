package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
public class FindMaximizedCapital {
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;

        for (int j = 0; j < k; j++) {
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll();
        }

        return w;
    }
    public static void main(String[] args[]){
        System.out.println(findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
}
