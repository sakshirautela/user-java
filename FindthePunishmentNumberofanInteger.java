package com.learn.java.problemsolving;

import java.util.Arrays;

public class FindthePunishmentNumberofanInteger {

    public boolean findPartitions(
            int startIndex,
            int sum,
            String stringNum,
            int target,
            int[][] memo) {
        if (startIndex == stringNum.length()) {
            return sum == target;
        }

        if (sum > target)
            return false;
        if (memo[startIndex][sum] != -1)
            return memo[startIndex][sum] == 1;

        boolean partitionFound = false;

        for (int currentIndex = startIndex; currentIndex < stringNum.length(); currentIndex++) {
            String currentString = stringNum.substring(
                    startIndex,
                    currentIndex + 1);
            int addend = Integer.parseInt(currentString);
            partitionFound = partitionFound ||
                    findPartitions(
                            currentIndex + 1,
                            sum + addend,
                            stringNum,
                            target,
                            memo);
            if (partitionFound) {
                memo[startIndex][sum] = 1;
                return true;
            }
        }

        memo[startIndex][sum] = 0;
        return false;
    }

    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            int squareNum = currentNum * currentNum;
            String stringNum = Integer.toString(squareNum);
            int[][] memoArray = new int[stringNum.length()][currentNum + 1];
            for (int[] row : memoArray) {
                Arrays.fill(row, -1);
            }
            if (findPartitions(0, 0, stringNum, currentNum, memoArray)) {
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }

    int arr[] = { 1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909,
            918, 945, 964, 990, 991, 999, 1000 };

    public int punishmentNumber2(int n) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= n) {
                res += arr[i] * arr[i];
            } else {
                break;
            }
        }
        return res;
    }
}