package com.learn.java.problemsolving;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MaxSumofaPairWithEqualSumofDigits {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] { 18, 43, 36, 13, 7 }));
    }

    public static int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, PriorityQueue<Integer>> group = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = 0;
            while (num > 0) {
                idx = idx + (num % 10);
                num /= 10;
            }
            if (!group.containsKey(idx)) {
                group.put(idx, new PriorityQueue<Integer>((a, b) -> b - a));
            }
            group.get(idx).add(nums[i]);
        }
        int res = -1;
        for (PriorityQueue<Integer> pq : group.values()) {
            if (pq.size() >= 2) {
                res = Math.max(res, pq.remove() + pq.remove());
            }
        }
        return res;
    }

    public int maximumSum2(int[] nums) {
        int[] max = new int[100];
        int ans = -1;
        for (int x : nums) {
            int dsum = 0;
            int temp = x;
            while (temp != 0) {
                dsum += temp % 10;
                temp /= 10;
            }
            if (max[dsum] != 0)
                ans = Math.max(ans, x + max[dsum]);
            max[dsum] = Math.max(max[dsum], x);
        }
        return ans;
    }
}