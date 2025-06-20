
public class FindNumberIslands {
    public static int numIslands(char[][] grid) {
        // Code here
        int res=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    getIsland(grid,i,j,m,n);
                    res++;
                }
            }
        }
        return res;
    }
    private static void getIsland(char[][] grid, int i, int j, int m, int n) {
        if(i<=-1 || j<=-1 || i>=m || j>=n || grid[i][j]=='0')
        {
            return ;
        }
        grid[i][j]='0';
        getIsland(grid,i-1,j,m,n);
        getIsland(grid,i,j-1,m,n);
        getIsland(grid,i+1,j,m,n);
        getIsland(grid,i,j+1,m,n);
        getIsland(grid,i-1,j+1,m,n);
        getIsland(grid,i+1,j-1,m,n);
        getIsland(grid,i+1,j+1,m,n);
        getIsland(grid,i-1,j-1,m,n);
    }
    public static void main(String args[]){
        System.out.println(numIslands(new char[][]{{}}));
    }
}
