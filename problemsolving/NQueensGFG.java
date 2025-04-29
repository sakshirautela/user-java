
import java.util.*;
public class NQueensGFG {
    static ArrayList<ArrayList<Integer>> res; 
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        res=new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        nqueens(board, 0, list);
        return res;
    }
    public static void main(String[] args) {
        System.out.println(nQueen(4));

    }
    public static boolean isSafe(char[][] board, int row, int col) {
        // diagonal1
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'q') {
                return false;
            }
        }
        // vertical
        for (int j = row - 1; j >= 0; j--) {
            if (board[j][col] == 'q') {
                return false;
            }
        }
        // horizontal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'q') {
                return false;
            }
        }
        return true;
    }

    public static void printchessBoard(char[][] board) {
        System.out.println("------");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nqueens(char[][] board, int rows,ArrayList<Integer> list) {
        if (rows == board.length) {
            printchessBoard(board);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if(isSafe(board, rows,i)){
                board[rows][i] = 'q';
                list.add(i+1);
                nqueens(board, rows + 1, list);
                board[rows][i] = '.';
                list.remove(list.size() - 1);
            }
        }
    }
}
