public class DiffOnesMinusZeros {
    public static int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int col[]=new int[m];
        int row[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    col[i]=col[i]+1;
                }
            }
        }
        for(int i=0;i<m;i++){
            System.out.print(col[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[j][i]==1){
                    row[i]=row[i]+1;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(row[i]+" ");
        }
        int [][] result = new int[m][n];
        for (int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length;j++){
                result[j][i] = col[j]+row[i]-(n-col[j])-(m-row[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] result=onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}});
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}