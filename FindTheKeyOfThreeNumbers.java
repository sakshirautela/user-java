package com.learn.java.problemsolving;

public class FindTheKeyOfThreeNumbers {
        public static int generateKey(int num1, int num2, int num3) {
            int res = 0;
            int maxDigits = Math.max(Math.max(String.valueOf(num1).length(), String.valueOf(num2).length()), String.valueOf(num3).length());
            int multiplier = 1;
    
            while (num1 > 0 || num2 > 0 || num3 > 0 || maxDigits > 0) {
                int minDigit = Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10));
                res = res + minDigit * multiplier;
                multiplier *= 10;
                
                num1 /= 10;
                num2 /= 10;
                num3 /= 10;
                maxDigits--;  // Reduce the remaining digits to be processed
            }
    
            return res;
        }
    public static void main(String[] args) {
        System.out.println(generateKey(282,718,1028));
    
    }
}