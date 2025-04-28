package com.learn.java.problemsolving;

public class Rotateby90DegreeGFG {
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("After Rotation");
        rotateby90(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void rotateby90(int mat[][]) {
        // code here
        int n=mat.length,i=0,j=n-1;
        while (i<j) {
            for (int k = 0; k < n; k++) {
                int temp=mat[k][j];
                mat[k][j]=mat[k][i];
                mat[k][i]=temp;
            }
            i++;
            j--;
        }
        for (int m = 0; m < n; m++) {
            for (int k = m+1; k < n; k++) {
                int temp=mat[m][k];
                mat[m][k]=mat[k][m];
                mat[k][m]=temp;
            }
        }
    }
}
