package com.learn.java.problemsolving;

import java.util.*;

public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int result = Integer.MAX_VALUE;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            int hr = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int min = Integer.parseInt(timePoints.get(i).substring(3));
            time[i] = (hr * 60 + min);
        }
        Arrays.sort(time);
        for (int i = 1; i < n; i++) {
            result = Math.min(result, (time[i] - time[i - 1]));
        }
        return Math.min(24 * 60 - time[n - 1] + time[0], result);
    }

    public int findMinDifference2(List<String> timePoints) {
        if (timePoints.size() > 1440)
            return 0;

        boolean[] seen = new boolean[1440];

        for (String time : timePoints) {
            int minutes = convertToMinutes(time);
            if (seen[minutes])
                return 0;
            seen[minutes] = true;
        }

        int first = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == Integer.MAX_VALUE) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }

        minDiff = Math.min(minDiff, 1440 - prev + first);

        return minDiff;
    }

    private int convertToMinutes(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60
                + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }

    public static void main(String[] args) {
        String[] arr = { "05:31", "22:08", "00:35" };
        List<String> newTime = new ArrayList<String>();
        for (String s : arr) {
            newTime.add(s);
        }
        System.out.println(findMinDifference(newTime));
    }
}