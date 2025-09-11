public class FindNumberofDaysBetweenTwoGivenDates {
    public static void main(String[] args) {
        System.out.println(noOfDays(2, 3, 4, 5, 6, 7));
    }

    // User function Template for Java
    static int noOfDays(int d1, int m1, int y1, int d2, int m2, int y2) {
        // code here
        return Math.abs(countDays(d2, m2, y2) - countDays(d1, m1, y1));
    }

    static int countDays(int d, int m, int y) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = y * 365 + leapYearsBefore(y-1);
        for (int i = 0; i < m - 1; i++) {
            days += month[i];
        }
        if (m >= 2 && isLeapYear(y)) {
            days += 1;
        }
        days += d;
        return days;
    }

    static int leapYearsBefore(int y) {
        return (y / 4) - (y / 100) + (y / 400);
    }

    static boolean isLeapYear(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }
}
