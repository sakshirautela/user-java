package com.learn.java.problemsolving;

public class RotatingTheBox {
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ch = new char[n][m];

        // Rotate the box 90 degrees clockwise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ch[j][m - 1 - i] = box[i][j];
            }
        }

        // Apply gravity to the rotated box
        for (int i = 0; i < ch[0].length; i++) { // Process each column
            int empty = ch.length - 1; // Start at the bottom of the column
            for (int j = ch.length - 1; j >= 0; j--) {
                if (ch[j][i] == '#') {
                    // Move '#' down to the next empty space
                    ch[j][i] = '.';
                    ch[empty][i] = '#';
                    empty--;
                } else if (ch[j][i] == '*') {
                    // Reset empty space pointer to just above '*'
                    empty = j - 1;
                }
            }
        }

        return ch;
    }

    public char[][] rotateTheBox2(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; ++i)
            for (int j = n - 1, k = n - 1; j >= 0; --j) {
                res[j][m - i - 1] = '.';
                if (box[i][j] != '.') {
                    k = box[i][j] == '*' ? j : k;
                    res[k--][m - i - 1] = box[i][j];
                }
            }
        return res;
    }

    public static void main(String[] args) {
        char[][] res = rotateTheBox(new char[][] { { '#', '.', '#' } });
        for (char[] ch : res) {
            for (char c : ch) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}