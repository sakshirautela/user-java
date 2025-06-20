public class MagicsquareInGride {
    public static int numMagicSquaresInside(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                if(isValid(i,j,grid)){
                    ans++;
                }
            }
        }
        return ans;
    }
    private static boolean isValid(int m, int n, int[][] grid) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[m + i][n + j];
                if (num < 1 || num > 9) return false;
                if (seen[num]) return false;
                seen[num] = true;
            }
        }
        int diag1=grid[m][n]+grid[m+1][n+1]+grid[m+2][n+2];
        int diag2=grid[m+2][n]+grid[m+1][n+1]+grid[m][n+2];
        if(diag2!=diag1){
            return false;
        }
        int row1=grid[m][n]+grid[m][n+1]+grid[m][n+2];
        int row2=grid[m+1][n]+grid[m+1][n+1]+grid[m+1][n+2];
        int row3=grid[m+2][n]+grid[m+2][n+1]+grid[m+2][n+2];
        if(!(row1==diag1 &&  row2==diag1 && row3==diag1 )){
            return false;
        }
        int col1=grid[m][n]+grid[m+1][n]+grid[m+2][n];
        int col2=grid[m][n+1]+grid[m+1][n+1]+grid[m+2][n+1];
        int col3=grid[m][n+2]+grid[m+1][n+2]+grid[m+2][n+2];
        if(!(col1==diag1 && col2==diag1 && col3==diag1 )){
            return false;
        }
        return true;

    }
    public static void main(String args[]){
        System.out.println(numMagicSquaresInside(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}}));
    }
}
