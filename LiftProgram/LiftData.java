import java.util.ArrayList;

public class LiftData {
    public static ArrayList<Integer> up = new ArrayList<>();
    public static ArrayList<Integer> down = new ArrayList<>();
    public static ArrayList<int[]> priority = new ArrayList<>();
    public synchronized void addLiftData(int dir, int src, int dest) {
        LiftData.priority.add(new int[]{src, dest, dir});
        if (dir == 1) {
            up.add(src);
            up.add(dest);
        } else {
            down.add(src);
            down.add(dest);
        }
    }
    public static ArrayList<Integer> getUp() {
        return up;
    }

    public static ArrayList<Integer> getDown() {
        return down;
    }
    public static ArrayList<int[]> getPriority() {
        return priority;
    }
}
