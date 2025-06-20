import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.close();

        int dayOfWeek = getStartDayOfYear(year); // 0=Sunday, 1=Monday, ..., 6=Saturday
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
       /* String[] months = {"January","February","March","April","May","June","July",
                           "August","September","October","November","December"};
        */
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // Adjust for leap year
        }

        System.out.println("January 1, " + year + " is a " + days[dayOfWeek]);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Returns the day of the week for January 1st of a given year (0=Sunday, ..., 6=Saturday)
    public static int getStartDayOfYear(int year) {
        int startDay = 4; // Jan 1, 1970 was a Thursday (4)
        for (int y = 1970; y < year; y++) {
            startDay = (startDay + (isLeapYear(y) ? 366 : 365)) % 7;
        }
        return startDay;
    }
}
