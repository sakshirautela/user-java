public class ShortestPathinaGridwithObstaclesElimination {
    public static void main(String[] args) {
        System.out.println(shortestPath(new int[][]{{}},4));
    }
    public static int shortestPath(int[][] grid, int k) {
        int m=grid.length;        
        int n=grid[0].length; 
        int result= shortestPathUtil(grid,m,n,0,0,0);
        return (result==Integer.MAX_VALUE)?-1:result;      
    }
    private static int shortestPathUtil(int[][] grid, int m, int n, int i, int j, int k) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==1){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return k;
        }
        int a=shortestPathUtil(grid,m,n,i+1,j,k+1);
        int b=shortestPathUtil(grid,m,n,i,j+1,k+1);
        int c=shortestPathUtil(grid,m,n,i-1,j,k+1);
        int d=shortestPathUtil(grid,m,n,i,j-1,k+1);
        return Math.min(a,Math.min(b,Math.min(c,d)));
    }
}