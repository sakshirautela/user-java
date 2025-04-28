package com.learn.java.problemsolving;

public class SetMatrixZeros {
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
    public static void main(String args[]){
        int[][] arr ={{1,1,1}};
        setZeroes(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}