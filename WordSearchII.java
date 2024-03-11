import java.util.*;

public class WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<String>();
        for (String s : words) {
            if(exist(board, s)) {
                list.add(s);
            }
        }
        return list;
    }

    public static boolean exist(char[][] board, String word) {
        for (int  i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isHelper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isHelper(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean result = isHelper(board, i, j - 1, word, idx + 1) || isHelper(board, i, j + 1, word, idx + 1)
                || isHelper(board, i - 1, j, word, idx + 1) || isHelper(board, i + 1, j, word, idx + 1);
        board[i][j] = temp;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = { { 'o', 'o', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        System.out.println(findWords(board, new String[] { "oath", "pea", "eat", "rain" }));
    }
}
