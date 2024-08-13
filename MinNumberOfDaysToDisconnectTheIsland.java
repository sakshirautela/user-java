public class MinNumberOfDaysToDisconnectTheIsland{
    public static int minDays(int[][] grid) {
        if(countIsland(grid)!=1){
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(countIsland(grid)!=1){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }
    private static int countIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for (int i = 0; i < m; i++) {
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                    dfs(visited,grid,m,n,i,j);
                }
            }
        }
        return count;
    }
    private static void dfs(boolean[][] visited, int[][] grid, int m, int n, int i, int j) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == 0 || visited[i][j]){
            return ;
        }
        visited[i][j]=true;
        dfs(visited,grid,m,n,i+1,j);
        dfs(visited,grid,m,n,i,j+1);
        dfs(visited,grid,m,n,i-1,j);
        dfs(visited,grid,m,n,i,j-1);
    }
    public static void main(String args[]){
        System.out.println(minDays(new int[][]{{}}));
    }
}