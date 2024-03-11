import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetweenExample {
    public static void main(String[] args) {
        // Specify the start date as January 14, 2023
        LocalDate startDate = LocalDate.of(2023, 1, 14);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the number of days between start date and current date
        long daysBetween = ChronoUnit.DAYS.between(startDate, currentDate);

        System.out.println("Number of days between " + startDate + " and " + currentDate + ": " + daysBetween);
    }
    
}