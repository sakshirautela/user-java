package com.learn.java.problemsolving;

public class ApplyOperationstoanArray {
    public static void main(String[] args) {
        int[] res = applyOperations(new int[] {});
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        for (int num : nums) {
            if (num != 0) {
                nums[zeroCount++] = num;
            }
        }
        while (zeroCount < n) {
            nums[zeroCount++] = 0;
        }
        return nums;
    }

    public int[] applyOperations2(int[] nums) {
        int[] newNums = new int[nums.length];
        int count = 0;
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    newNums[count] = nums[i] * 2;
                    i++;
                } else
                    newNums[count] = nums[i];
                count++;
            }
        }
        if (i != nums.length)
            newNums[count] = nums[nums.length - 1];
        return newNums;
    }
    /*
      StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                res.append(s.charAt(i));
            } else {
                StringBuilder temp = new StringBuilder();
                while (res.length() > 0 && res.charAt(res.length() - 1) != '[') {
                    temp.append(res.charAt(res.length() - 1));
                    res.deleteCharAt(res.length() - 1);
                }
                temp.reverse();
                res.deleteCharAt(res.length() - 1); // Remove '['
                
                StringBuilder num = new StringBuilder();
                while (res.length() > 0 && Character.isDigit(res.charAt(res.length() - 1))) {
                    num.append(res.charAt(res.length() - 1));
                    res.deleteCharAt(res.length() - 1);
                }
                num.reverse();
                int val = Integer.parseInt(num.toString());

                while (val-- > 0) {
                    res.append(temp);
                }
            }
        }
        return res.toString();
     */
}