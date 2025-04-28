package com.learn.java.problemsolving;

public class FinalPricesWithaSpecialDiscountinaShop {
    public static void main(String[] args) {
        int[] res = finalPrices(new int[] {});
    }

    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while (j < prices.length && prices[i] < prices[j]) {
                j++;
            }
            prices[i] -= (j == prices.length) ? 0 : prices[j];
        }
        return prices;
    }

    public int[] finalPrices2(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            int discount = findDiscountOfIndex(i, prices);
            prices[i] = prices[i] - discount;
        }

        return prices;
    }

    private static int findDiscountOfIndex(int i, int[] prices) {
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[j] <= prices[i]) {
                return prices[j];
            }
        }
        return 0;
    }
}