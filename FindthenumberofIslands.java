public class FindthenumberofIslands {
    public static void main(String[] args) {
        
    }
    public int countIslands(char[][] grid) {
        // Code here
        int res=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='L'){
                    getIsland(grid,i,j,m,n);
                    res++;
                }
            }
        }
        return res;
    }
    private static void getIsland(char[][] grid, int i, int j, int m, int n) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='W')
        {
            return ;
        }
        grid[i][j]='W';
        getIsland(grid,i-1,j,m,n);
        getIsland(grid,i,j-1,m,n);
        getIsland(grid,i+1,j,m,n);
        getIsland(grid,i,j+1,m,n);
        getIsland(grid,i-1,j+1,m,n);
        getIsland(grid,i+1,j-1,m,n);
        getIsland(grid,i+1,j+1,m,n);
        getIsland(grid,i-1,j-1,m,n);
    }
}