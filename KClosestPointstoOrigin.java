package com.learn.java.problemsolving;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public static void main(String[] args) {
        int[][] res = kClosest(new int[][] { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } }, 2);
        for (int[] is : res) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        // Your code here
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->( a[0] * a[0]+a[1] *a[1])-(b[0] * b[0]+b[1] * b[1]));
        for (int i = 0; i < points.length; i++) {
            pq.add(new int[] { points[i][0], points[i][1]});
        }
        int idx = 0;
        while (idx < k && !pq.isEmpty()) {
            int[] temp = pq.remove();
            res[idx] = new int[] { temp[0], temp[1] };
            idx++;
        }
        return res;
    }
    public int[][] kClosest2(int[][] points, int k) {
        int res[][] = new int[k][2];
        Arrays.sort(points, (a, b) -> {
           return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]); 
        });
        
        int idx=0;
        while(idx < k) {
            res[idx] = points[idx];
            idx++;
        }
        
        return res;
    }
}