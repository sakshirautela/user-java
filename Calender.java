package com.learn.java.problemsolving;

import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base_year = 1973;
        int base_day = 1; // Assuming Jan 1, 1973 is a Monday

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        // Adjust February days in leap years
        if (isLeapYear(year)) {
            days[1] = 29;
        }

        int total_days = 0;

        // Find total days from base year to given year
        for (int i = base_year; i < year; i++) {
            if (isLeapYear(i)) {
                total_days += 366;
            } else {
                total_days += 365;
            }
        }

        int dayOfWeek = (base_day + total_days) % 7; // 0: Monday, 1: Tuesday, etc.

        printCalendar(year, dayOfWeek, months, days);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void printCalendar(int year, int startDay, String[] months, int[] days) {
        System.out.println("\nCalendar for year " + year + ":\n");

        for (int i = 0; i < 12; i++) {
            System.out.println("\n\n\t\t" + months[i] + " " + year);
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            for (int k = 0; k < startDay; k++) {
                System.out.print("    "); // 4 spaces for each empty day
            }

            for (int j = 1; j <= days[i]; j++) {
                System.out.printf("%3d ", j);

                if ((j + startDay) % 7 == 0) {
                    System.out.println();
                }
            }

            startDay = (startDay + days[i]) % 7; // Update startDay for next month
        }
    }
}
