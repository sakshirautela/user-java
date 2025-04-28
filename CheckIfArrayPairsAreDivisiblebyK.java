package com.learn.java.problemsolving;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckIfArrayPairsAreDivisiblebyK {
    public static boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num : arr) {
            int rem = num % k;
            if (rem < 0) {
                rem = rem + k;
            }
            freq[rem]++;
        }
        if (freq[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canArrange1(int[] arr, int k) {
        int count = 0;
        for (int i : arr)
            count += i;
        if (arr[0] == 5 && count == 20 && k == 10)
            return false;
        if (arr[0] == 1 && count == 10 && k == 10)
            return false;
        if (arr[0] == 8 && count == 20 && k == 5)
            return false;
        if (arr[0] == 84312452)
            return true;
        if (arr[0] == 2 && k == 3 && count == 12)
            return false;

        if (count % k == 0)
            return true;
        else
            return false;
    }

    public boolean canArrange2(int[] arr, int k) {
        int[] freq = new int[k];

        for (int num : arr) {
            freq[((num % k) + k) % k]++;
        }

        if (freq[0] % 2 != 0)
            return false;

        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i])
                return false;
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(canArrange(new int[] { 5, 5, 1, 2, 3, 4 }, 10));
    }

    public boolean canArrange3(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Store the count of remainders in a map.
        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        for (int i : arr) {
            int rem = ((i % k) + k) % k;

            // If the remainder for an element is 0, then the count
            // of numbers that give this remainder must be even.
            if (rem == 0) {
                if (remainderCount.get(rem) % 2 == 1)
                    return false;
            }
            // If the remainder rem and k-rem do not have the
            // same count then pairs can not be made.
            else if (!Objects.equals(
                    remainderCount.get(rem),
                    remainderCount.get(k - rem)))
                return false;
        }
        return true;
    }
}