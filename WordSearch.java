public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;  
        }
        //agar vo i pr tha vha se i+1 pr gya or i-1 hua to fir vaps aa jayega to hm usko blank kr denege jisse vo idx se match nehi hoga
        char temp=board[i][j];
        board[i][j] = ' ';
        boolean result =helper(board, i, j - 1, word, index + 1) || helper(board, i, j + 1, word, index + 1) || helper(board, i - 1, j, word, index + 1) || helper(board, i + 1, j, word, index + 1);
        board[i][j] =temp;//realloacate
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABAB"));
    }
}
