package problemsolvingIII;

public class FurthestPointFromOrigin {
    static void main() {
        System.out.println(furthestDistanceFromOrigin("L_RL__R"));
    }

    public static int furthestDistanceFromOrigin(String moves) {
        int point = 0;
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                x--;
                y--;
            } else if (c == 'R') {
                x++;
                y++;
            } else {
                x--;
                y++;
            }

        }
        point = Math.max(point, Math.abs(x));
        point = Math.max(point, Math.abs(y));
        return point;
    }
}