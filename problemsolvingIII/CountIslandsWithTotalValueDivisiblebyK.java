package problemsolvingIII;

public class CountIslandsWithTotalValueDivisiblebyK {
    static void main() {
        System.out.println(countIslands(new int[][]{{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}},5));
    }
    public static int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) {
                    if(countIslandsHelper(i,j,rows,cols,grid)%k==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private static long countIslandsHelper(int i, int j, int rows, int cols,int[][] grid) {
        if( i>=rows || j>=cols || j<0 || i<0 || grid[i][j]==0) {
            return 0;
        }
        long val=grid[i][j];
        grid[i][j] = 0;
        return val+countIslandsHelper(i+1,j,rows,cols,grid)+countIslandsHelper(i,j-1,rows,cols,grid)+countIslandsHelper(i,j+1,rows,cols,grid)+countIslandsHelper(i-1,j,rows,cols,grid);
    }
}
