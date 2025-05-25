import java.util.LinkedList;
import java.util.Queue;

public class StepsbyKnight {
    public static void main(String[] args) {
        System.out.println(minStepToReachTarget(new int[]{3, 3},new int[]{1,2},3));
    }
    static int[][] moves = {
       {+1, +2}, {+2, +1}, {+2, -1}, {+1, -2},
       {-1, -2}, {-2, -1}, {-2, +1}, {-1, +2}
   };
    public static int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{knightPos[0]-1,knightPos[1]-1,0});
        visited[knightPos[0]-1][knightPos[1]-1]=true;
        while (!q.isEmpty()) {
            int[] curr=q.poll();
            if(curr[0]==targetPos[0]-1&& curr[1]==targetPos[1]-1){
                return curr[2];
            }
            for (int[] m : moves) {
                int nr=curr[0]+m[0];
                int nc=curr[1]+m[1];
                if(isSafe(nr,nc,n,visited)){
                    q.add(new int[]{nr,nc,curr[2]+1});
                    visited[nr][nc]=true;
                }
            }
        }
        return -1;
    }

    private static boolean isSafe(int i, int j,int n, boolean[][] visited) {
        if(i<0 || j<0 || i>=n || j>=n || visited[i][j]){
            return false;
        }
        return true;
    }

    public static int minStepToReachTargetDFS(int knightPos[], int targetPos[], int n) {
        // Code here
        boolean[][] visited = new boolean[n][n];
        return minStepToReachTarget(knightPos[0]-1,knightPos[1]-1, targetPos[0]-1,targetPos[1]-1, n,visited);
    }
    private static int minStepToReachTarget(int i, int j, int k, int l, int n,boolean visited[][]) {
        if(i<0 || j<0 || i>=n || j>=n || visited[i][j]){
            return Integer.MAX_VALUE;
        }
        if(i==k&&j==l){
            return 0;
        }
        visited[i][j]=true;
        int a=Integer.MAX_VALUE;
        for (int[] m : moves) {
            a=Math.min(minStepToReachTarget(i+m[0], j+m[1], k, l, n,visited),a);
        }
        visited[i][j]=false;
        return a==Integer.MAX_VALUE?a:a+1;
    }
}