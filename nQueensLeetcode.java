import java.util.ArrayList;
import java.util.List;

public class nQueensLeetcode {
    public static void main(String[] args) {
        int n = 5;
        List<List<String>> board = new ArrayList<List<String>>();
        List<String> list = new ArrayList<>();
        System.out.println(nqueens(board, n));

    }

    /*public static boolean isSafe(List<List<String>> result, int row, int col) {
        // diagonal1
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (result[i][j] == 'q') {
                return false;
            }
        }
        // vertical
        for (int j = row - 1; j >= 0; j--) {
            if (result[j][col] == 'q') {
                return false;
            }
        }
        // horizontal
        for (int i = row - 1, j = col + 1; i >= 0 && j < result.length; i--, j++) {
            if (result[i][j] == 'q') {
                return false;
            }
        }
        return true;
    }*/

    
    public static List<List<String>> nqueens(List<List<String>> result, int rows) {
        if (rows == result.size()) {
            return result;
        }
        for (int i = 0; i < result.size(); i++) {
            //if (isSafe(result, rows, i)) {
                list.add("Q");
                nqueens(result, rows + 1);
                list.add(".");

            //}
        }
        return result;
    }
}
