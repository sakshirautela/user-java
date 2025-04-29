public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        gameOfLife(board);
        System.out.println(" After Modification : -");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public static void gameOfLife(int[][] board) {
        int n = board[0].length;
        int m = board.length;
        int[][] dummy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dummy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getNeighbour(dummy, i, j, m, n);
                if (dummy[i][j] == 1) {
                    if (count < 2 || count > 3)
                        board[i][j] = 0;
                    else
                        board[i][j] = 1;
                } else {
                    if (count == 3)
                        board[i][j] = 1;
                    else
                        board[i][j] = 0;
                }
            }
        }
    }

    private static int getNeighbour(int[][] dummy, int i, int j, int m, int n) {
        int count = 0;
        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && dummy[ni][nj] == 1) {
                count++;
            }
        }
        return count;
    }
}
