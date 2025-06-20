import java.util.LinkedList;
import java.util.Queue;

public class MaximumCandiesYouCanGetfromBoxes {
    public static void main(String[] args) {
        System.out
                .println(maxCandies(new int[] {}, new int[] {}, new int[][] { {} }, new int[][] { {} }, new int[] {}));
    }

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
            int[] initialBoxes) {
        int candy = 0;
        Queue<Integer> q = new LinkedList<>();
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] canOpen = new boolean[n];
        boolean[] opend = new boolean[n];
        for (int i = 0; i < n; i++) {
            canOpen[i] = (status[i] == 1);
        }
        for (int i : initialBoxes) {
            hasBox[i] = true;
            if (canOpen[i]) {
                opend[i] = true;
                q.offer(i);
                candy += candies[i];
            }
        }
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i : keys[c]) {
                canOpen[i] = true;
                if (!opend[i] && hasBox[i]) {
                    opend[i] = true;
                    q.offer(i);
                    candy += candies[i];
                }
            }
            for (int i : containedBoxes[c]) {
                hasBox[i] = true;
                if (canOpen[i] && !opend[i]) {
                    opend[i] = true;
                    q.offer(i);
                    candy += candies[i];
                }
            }
        }
        return candy;
    }
    public int maxCandies2(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candiesCount = 0;
        boolean[] visited = new boolean[status.length];
        for(int box: initialBoxes){
            dfs(box, status, keys, containedBoxes, visited);
        }
        for(int i = 0; i < candies.length; i++){
            if(visited[i] && status[i] == 1){
                candiesCount += candies[i];
            }
            
        }
        return candiesCount;
    }


    private void dfs(int box, int[] status, int[][] keys, int[][] containedBoxes, boolean[] visited){
        visited[box] = true;
        for(int key: keys[box]){
            if(key == box){
                continue;
            }
            status[key] = 1;
        }
        for(int bx: containedBoxes[box]){
            if(!visited[bx]){
                dfs(bx, status, keys, containedBoxes, visited);
            }
        }
    }
}