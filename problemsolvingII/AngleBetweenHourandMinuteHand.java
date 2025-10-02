public class AngleBetweenHourandMinuteHand {
    public static void main(String[] args) {
        System.out.println(getAngle("00:33"));
    }

    public static double getAngle(String s) {
        // code here
        double result = 0;
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        h %= 12;
        result = Math.abs(30 * h - 5.5 * m);
        return Math.min(360 - result, result);
    }
}
