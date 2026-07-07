package problemsolvingIII;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BlockPlacementQueries {
    static void main() {
        System.out.println(getResults(new int[][]{{1,7},{2,7,6},{1,2},{2,7,5},{2,7,6}}));
    }

    public static List<Boolean> getResults(int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        TreeSet<Integer> obstacles = new TreeSet<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                obstacles.add(x);
            } else {
                int x = q[1];
                int size = q[2];

                boolean canPlace = false;
                int prev = 0;

                for (int obstacle : obstacles) {
                    if (obstacle > x) {
                        break;
                    }

                    if (obstacle - prev >= size) {
                        canPlace = true;
                        break;
                    }

                    prev = obstacle;
                }

                if (!canPlace && x - prev >= size) {
                    canPlace = true;
                }

                result.add(canPlace);
            }
        }

        return result;
    }
}
