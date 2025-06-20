public class RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded(""));
    }

    static int directions[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    public static boolean isRobotBounded(String instructions) {
        int dir = 0;
        int x = 0, y = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                x += directions[dir][0];
                y += directions[dir][1];
            } else if (ch == 'R') {
                dir = (dir + 1) % 4;
            } else {
                dir = (dir + 3) % 4;
            }
        }
        return x == 0 && y == 0 || dir > 0;
    }
}