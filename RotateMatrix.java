class RotateMatrix {
    public static void rotateMatrix(int[][] matrix) {
        int n=matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i <n;i++){
            temp[0][i] = matrix[i][0];
        }
        System.out.println();
        for (int i = 0; i <n;i++){
            temp[1][i] = matrix[0][i];
        }
        System.out.println();       
         System.out.println();

        int r=0;
        int c=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                matrix[r][c]=matrix[i][j];
                r++;
            }
            c++;
            r=0;
        }
        for (int i = 0; i <n;i++){
            matrix[i][n-1] = temp[1][i];
        }
        int idx = 0;
        for (int i = n-1; i >=0;i--){
            matrix[0][idx]=temp[0][i];
                idx++;
        }
    }
    public static void main(String[] args) {
        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}