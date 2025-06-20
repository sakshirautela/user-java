import java.util.LinkedList;
import java.util.Queue;

public class KnightProbabilityinChessboard {
    public static void main(String[] args) {
        System.out.println(knightProbability(8,3,4,5));
    }
    static int[][] moves = {
       {+1, +2}, {+2, +1}, {+2, -1}, {+1, -2},
       {-1, -2}, {-2, -1}, {-2, +1}, {-1, +2}
   };
    public static double knightProbability(int n, int k, int row, int column) {
         boolean[][] visited = new boolean[n][n];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{row,column,k});
        visited[row][column]=true;
        int count=0;
        while (!q.isEmpty()) {
            int[] curr=q.poll();
            if(curr[2]==k && isSafe(curr[0], curr[1], n, visited)){
                count++;
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
        double d=count/n;
        return d;
    }
      private static boolean isSafe(int i, int j,int n, boolean[][] visited) {
        if(i<0 || j<0 || i>=n || j>=n || visited[i][j]){
            return false;
        }
        return true;
    }
}