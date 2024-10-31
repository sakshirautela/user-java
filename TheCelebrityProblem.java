public class TheCelebrityProblem {
    public static void main(String[] args) {
        System.out.println(celebrity(new int[][]{{0,0,0},{0,0,0},{0,1,0}}));
    }
    public static int celebrity(int mat[][]) {
        int n=mat.length;
        for (int i = 0; i < n; i++) {
            int isum=0;
            int jsum=0;
            for (int j = 0; j < n; j++) {
                isum+=mat[i][j];
                jsum+=mat[j][i];
            }
            if(isum==0 && jsum==n-1){
                return i;
            }
        }
        return -1;
    }
}
