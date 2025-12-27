public class TwistedMirrorPathCount2 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(new int[][]{{}}));
    }
    public  static int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] marked=new boolean[n][m];
        uniquePathsHelper(0,0,n,m,grid,marked);
        return  0;
    }
    public static  int uniquePathsHelper(int i,int j,int n,int m,int[][] grid,boolean[][]marked){
return 0;
    }
}