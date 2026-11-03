package problemsolvingIII;

public class CountDaysSpentTogether {

    static int[] month = {
            31, 59, 90, 120, 151, 181,
            212, 243, 273, 304, 334, 365
    };

    public static void main(String[] args) {
        System.out.println(
                countDaysTogether("10-01", "10-31", "11-01", "12-31")
        );
    }

    public static int countDaysTogether(
            String arriveAlice, String leaveAlice,
            String arriveBob, String leaveBob) {

        int a = convertToDay(arriveAlice);
        int b = convertToDay(leaveAlice);
        int c = convertToDay(arriveBob);
        int d = convertToDay(leaveBob);

        int start = Math.max(a, c);
        int end = Math.min(b, d);

        return Math.max(0, end - start + 1);
    }

    private static int convertToDay(String date) {
        int monthNumber = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int previousMonthDays = monthNumber == 1
                ? 0
                : month[monthNumber - 2];

        return previousMonthDays + day;
    }
}
