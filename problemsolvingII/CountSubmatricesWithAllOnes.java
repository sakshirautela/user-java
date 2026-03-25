public class CountSubmatricesWithAllOnes {

    void main() {
        System.out.println(numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
    }

    public static int numSubmat(int[][] mat) {
        int result = 0;
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j==0){
                    row[i][j] = mat[i][j];
                }else{
                    row[i][j] = (mat[i][j]==0)?0:row[i][j-1]+1;
                }
                int r=row[i][j];
                for(int k=i;k>=0;k--){
                    r=Math.min(row[k][j],r);
                    if(r==0){
                        break;
                    }
                    result+=r;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(row[i][j]+" ");
//            }
//        System.out.println();
//        }
        return result;
    }
}