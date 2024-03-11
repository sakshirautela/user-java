class SetZeroes {
    public static void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                  row[i] = true;
                  col[j] = true;  
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(row[i]){
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] =0;
                }
            }
        }
        for(int j = 0; j <matrix[0].length; j++) {
            if(col[j]){
                for(int i = 0; i < matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}