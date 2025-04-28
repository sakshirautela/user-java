package com.learn.java.problemsolving;

public class MaximumPopulationYear {
    public static void main(String[] args) {
        int[][] logs = {{1993, 1999}, {2000, 2010}};
        System.out.println(maximumPopulation(logs)); // Output should be 1993
    }

    public static int maximumPopulation(int[][] logs) {
        int[] population = new int[2051]; // because year range is usually 1950 to 2050

        // Mark birth and death years
        for (int[] log : logs) {
            population[log[0]]++;  // birth
            population[log[1]]--;  // death
        }

        int maxAlive = 0;
        int year = 0;
        int curr = 0;

        for (int i = 1950; i <= 2050; i++) {
            curr += population[i];
            if (curr > maxAlive) {
                maxAlive = curr;
                year = i;
            }
        }

        return year;
    }
}
