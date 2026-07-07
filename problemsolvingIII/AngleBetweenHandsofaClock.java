package problemsolvingIII;

public class AngleBetweenHandsofaClock {
    static void main() {

    }

    public double angleClock(int hour, int minutes) {
        return 180-Math.abs(30 * hour + 5.5 * minutes);
    }
}
