package problemsolvingIII;

import java.util.LinkedList;
import java.util.Queue;

public class TwowaterJugproblem {
    static void main() {
        System.out.println(minSteps(3, 4, 5));
    }

    public static int minSteps(int m, int n, int d) {
        // code here
        if (d > Math.max(m, n)) return -1;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m + 1][n + 1];
        queue.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int j1 = cur[0];
            int j2 = cur[1];
            int step = cur[2];
            if (j1 == d || j2 == d) return step;
            if(!visited[m][j2]) {
                visited[m][j2] = true;
                queue.offer(new int[]{m, j2, step + 1});
            }
            if(!visited[j1][n]) {
                visited[j1][n] = true;
                queue.offer(new int[]{j1, n, step + 1});
            }
            if(!visited[0][j2]) {
                visited[0][j2] = true;
                queue.offer(new int[]{0, j2, step + 1});
            }
            if(!visited[j1][0]) {
                visited[j1][0] = true;
                queue.offer(new int[]{j1, 0, step + 1});
            }
            int min=Math.min(j1,n-j2);
            if(!visited[j1-min][j2+min]) {
                visited[j1-min][j2+min] = true;
                queue.offer(new int[]{j1-min, j2+min, step + 1});
            }
            min = Math.min(m-j1,j2);
            if(!visited[j1+min][j2-min]) {
                visited[j1+min][j2-min] = true;
                queue.offer(new int[]{j1+min, j2-min, step + 1});
            }
        }
        return -1;
    }
}
