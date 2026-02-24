import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryWatch {
    static void main() {
        System.out.println(readBinaryWatch(3));
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        int[] watch = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        Set<String> set = new HashSet<>();
        getAllPossibleUseCases(0, 0, 0, turnedOn, 0, 0, set, watch);
        return new ArrayList<>(set);
    }

    private static void getAllPossibleUseCases(int index, int i, int j, int turnedOn, int hour, int minute, Set<String> set, int[] watch) {
        if (i + j > turnedOn) {
            return;
        }
        if (i >= 4 || j >= 5) {
            return;
        }
        if (turnedOn == i + j) {
            if (minute < 10) {
                set.add(Integer.toString(hour) + ":0" +Integer.toString(minute));
            } else {
                set.add(Integer.toString(hour) + ":" +Integer.toString(minute));
            }
            return;
        }
        for (int k = index; k < 10; k++) {
            if (k < 4) {
                getAllPossibleUseCases(k, i + 1, j, turnedOn, hour + watch[k], minute, set, watch);
            } else {
                getAllPossibleUseCases(k, i, j + 1, turnedOn, hour, minute + watch[k], set, watch);
            }
        }
    }
}
