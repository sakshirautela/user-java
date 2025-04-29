
import java.util.*;
public class nQueensLeetcodeSol {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    
    }
    static List<List<String>>  res; 
    public static List<List<String>> solveNQueens(int n) {
        // code here
        res=new ArrayList<>();
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ".";
            }
        }
        List<String> list=new ArrayList<String>();
        nqueens(board, 0, list);
        return res;
    }
    public static boolean isSafe(String[][] board, int row, int col) {
        // diagonal1
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q") {
                return false;
            }
        }
        // vertical
        for (int j = row - 1; j >= 0; j--) {
            if (board[j][col] == "Q") {
                return false;
            }
        }
        // horizontal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == "Q") {
                return false;
            }
        }
        return true;
    }

    
    public static void nqueens(String[][] board, int rows,List<String> list) {
        if (rows == board.length) {
            printchessBoard(board);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if(isSafe(board, rows,i)){
                board[rows][i] = "Q";
                String s="";
                for(int k=0;k<board[rows].length;k++){
                    s=s+board[rows][k];
                }
                list.add(s);
                nqueens(board, rows + 1, list);
                board[rows][i] = ".";
                list.remove(list.size() - 1);
            }
        }
    }
    public static void printchessBoard(String[][] board) {
        System.out.println("------");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
