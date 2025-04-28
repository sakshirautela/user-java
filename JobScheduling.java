package com.learn.java.problemsolving;

import java.util.*;

public class JobScheduling {
    static class Job {
        int id, profit, deadline;

        public Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

    }

    // Function to find the maximum profit and the number of jobs done.
    public static int[] JobScheduling(Job arr[], int n) {
        int[] res = new int[2];
        Arrays.sort(arr, (a, b)-> b.profit-a.profit);
        // Your code here
        int maxDeadline = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }
        int[] dp = new int[maxDeadline + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j =arr[i].deadline ; j > 0; j--) {
                if (dp[j] == -1) {
                    dp[j] = arr[i].profit;
                    res[1] +=arr[i].profit;
                    res[0] += 1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] res = JobScheduling(
            new Job[]{new Job(1,4,20), new Job(2, 2, 27), new Job(3, 1, 25), new Job(4, 1, 15)}, 
            4
        );
        // Print the scheduled jobs
        System.out.println(Arrays.toString(res));
    }
}