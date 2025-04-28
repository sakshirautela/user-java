package com.learn.java.problemsolving;

public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        int len=image[0].length;
        for(int[] arr:image){
            for(int i=0;i<(len+1)/2;i++){
                int temp=arr[i]^1;
                arr[i]=arr[len-1-i]^1;
                arr[len-1-i]=temp;
            }
        }
        return image;
    }
    public static void main(String args[]){
        int[][] flip={{1,1,0},{1,0,1},{0,0,0}};
        flip=flipAndInvertImage(flip);
        for(int i=0;i<flip.length;i++){
            for(int j=0;j<flip[0].length;j++){
                System.out.print(flip[i][j]+" ");
            }
            System.out.println();
        }
    }
}