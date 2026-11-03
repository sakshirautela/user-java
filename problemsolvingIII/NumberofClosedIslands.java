package problemsolvingIII;

public class NumberofClosedIslands {
    static void main() {
        System.out.println(closedIsland(new int[][]{}));
    }
    public static int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    if(closedIslandHelper(i,j,rows,cols,visited,grid)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean closedIslandHelper(int i, int j, int rows, int cols, boolean[][] visited,int[][] grid) {
        if(visited[i][j] || i>=rows || j>=cols || j<0 || i<0 || grid[i][j]==1) {
            return false;
        }
        if((i==rows-1 || j==cols-1 || i==0 || j==0) && grid[i][j]==0) {
            return false;

        }
        visited[i][j] = true;
        boolean a=closedIslandHelper(i+1,j,rows,cols,visited,grid);
        if(!a){
            return false;
        }
        a=closedIslandHelper(i,j-1,rows,cols,visited,grid);
        if(!a){
            return false;
        }
        a=closedIslandHelper(i,j+1,rows,cols,visited,grid);
        if(!a){
            return false;
        }
        a=closedIslandHelper(i-1,j,rows,cols,visited,grid);
        return a;
    }
}
