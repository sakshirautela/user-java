package com.learn.java.problemsolving;

public class TheTwoSneakyNumbersofDigitville {
    public static int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[100];
        for (int i : nums) {
            freq[i]++;
        }
        int[] res = new int[2];
        int idx = 0;
        for (int i = 0; i <= 100; i++) {
            if (freq[i] == 2) {
                res[idx] = i;
                idx++;
            }
        }
        return res;
    }

    public int[] getSneakyNumbers2(int[] nums) {
        int[] result = new int[2];
        int n = nums.length - 2;
        boolean[] found = new boolean[n + 2];
        int index = 0;
        for (int num : nums) {
            if (found[num]) {
                result[index++] = num;

            } else {
                found[num] = true;
            }
            if (index == 2) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = getSneakyNumbers(new int[] {});
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}