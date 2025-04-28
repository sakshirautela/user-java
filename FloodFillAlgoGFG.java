package com.learn.java.problemsolving;

public class FloodFillAlgoGFG {
    public static void main(String[] args) {
        int[][] res = floodFill(new int[][] { {} }, 2, 3, 4);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int n=image[0].length;
        int m=image.length;
        int color=image[sr][sc];
        if(color==newColor){
            return image;
        }
        floodFillUtill(image, sr, sc,m,n, newColor,color);
        return image;
        
    }
    private static void floodFillUtill(int[][] image, int i, int j, int m, int n, int newColor,int color) {
        if(i==m || j==n || i<0||j<0||image[i][j]!=color){
            return ;
        }
        image[i][j]=newColor;
        floodFillUtill(image, i, j+1,m,n, newColor,color);
        floodFillUtill(image, i, j-1,m,n, newColor,color);
        floodFillUtill(image, i+1, j,m,n, newColor,color);
        floodFillUtill(image, i-1, j,m,n, newColor,color);
    }
}