package com.learn.java.problemsolving;

public class srt {
    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "12";

        if (num1.equals("0") || num2.equals("0")) {
            System.out.println("0");
            return;
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10; // place current digit
                result[i + j] += sum / 10;    // carry to previous place
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // skip leading zeroes
            if (sb.length() == 0 && num == 0) continue;
            sb.append(num);
        }

        System.out.println(sb.toString());
    }
}
