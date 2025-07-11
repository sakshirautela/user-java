public class SolveSudoku {
    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        solveSudoku(board);
        for (char[] cs : board) {
            for (char c : cs) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        solved(board,0,0);
        return ;
    }

    private static boolean solved(char[][] board, int i, int j) {
        if(i==9){
            return true;
        }
        if(j==9){
            return solved(board, i+1, 0);
        }
        if(board[i][j]!='.'){
            return solved(board, i, j+1);
        }
        for(char ch='1';ch<='9';ch++){
            if(isValid(board, i, j, ch)){
                board[i][j]=ch;
                if(solved(board, i, j+1)){
                    return true;
                }
                board[i][j]='.';
            }
        }
        return false;
    }

    public static boolean isValid(char[][] board, int i, int j, char ch) {
        int s = (i / 3)*3;
        int t = (j / 3)*3;
        for (int m = s; m < s + 3; m++) {
            for (int n = t; n < t + 3; n++) {
                if (board[m][n] == ch) {
                    return false;
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            if(board[i][k]==ch){
                return false;
            }
            if(board[k][j]==ch){
                return false;
            }
        }
        return true;
    }
}
/*
class Solution {

    // Constants
    private final static int SIZE = 9;               // 9x9 board
    private final static int BLOCK_SIZE = 3;         // 3x3 sub-grid
    private final static char EMPTY_CELL = '.';      // placeholder for empty cells
    private final static int allBits = 0x1ff;        // 9 bits set to 1: 0b111111111 = 511

    // Bit flags for digits 1 to 9 → bitFlags[0] = 1 (000000001), ..., bitFlags[8] = 256 (100000000)
    private final static int[] bitFlags = {
        0x1, 0x2, 0x4, 0x8, 0x10, 0x20, 0x40, 0x80, 0x100
    };

    // Shared state
    private char[][] board;
    private int[] rows = new int[SIZE];    // Used digits in each row
    private int[] cols = new int[SIZE];    // Used digits in each column
    private int[] blocks = new int[SIZE];  // Used digits in each 3x3 block
    private int totalCount = 0;            // Number of cells filled so far

    public void solveSudoku(char[][] board) {
        this.board = board;
        initializeBoard();      // Set up bitmasks based on initial board
        backtrack();            // Solve using optimized backtracking
    }

    // Initialize the bitmasks with already-filled digits on the board
    private void initializeBoard() {
        for (int r = 0; r < SIZE; ++r) {
            for (int c = 0; c < SIZE; ++c) {
                if (board[r][c] != EMPTY_CELL) {
                    int value = board[r][c] - '1';  // Convert '1'-'9' to 0–8
                    mark(value, r, c);              // Mark bitmasks for that digit
                }
            }
        }
    }

    // Backtracking function to fill in the board
    private boolean backtrack() {
        if (totalCount == SIZE * SIZE) return true; // All cells filled

        // Heuristic: find the empty cell with the fewest candidates (minimize branching)
        int minCandidates = SIZE + 1;
        int targetRow = -1, targetCol = -1;

        for (int r = 0; r < SIZE && minCandidates > 1; ++r) {
            for (int c = 0; c < SIZE; ++c) {
                if (board[r][c] != EMPTY_CELL) continue;
                int count = Integer.bitCount(getCandidates(r, c));
                if (count < minCandidates) {
                    minCandidates = count;
                    targetRow = r;
                    targetCol = c;
                }
            }
        }

        if (minCandidates == 0) return false; // Dead end (no valid digits)

        int candidates = getCandidates(targetRow, targetCol);

        // Try each valid candidate digit using bitmask
        for (int i = 0; i < SIZE && candidates != 0; ++i, candidates >>= 1) {
            if ((candidates & 1) == 0) continue; // Skip if bit is not set

            // Place digit i at (targetRow, targetCol)
            mark(i, targetRow, targetCol);
            board[targetRow][targetCol] = (char) (i + '1');

            // Recurse
            if (backtrack()) return true;

            // Backtrack
            board[targetRow][targetCol] = EMPTY_CELL;
            unmark(i, targetRow, targetCol);
        }

        return false;
    }

    // Get bitmask of available digits for (row, col)
    private int getCandidates(int row, int col) {
        int blockIdx = (row / 3) * 3 + (col / 3);
        return ~(rows[row] | cols[col] | blocks[blockIdx]) & allBits;
    }

    // Mark digit `value` as used at (row, col)
    private void mark(int value, int row, int col) {
        int blockIdx = (row / 3) * 3 + (col / 3);
        rows[row] |= bitFlags[value];
        cols[col] |= bitFlags[value];
        blocks[blockIdx] |= bitFlags[value];
        totalCount++;
    }

    // Unmark digit `value` from (row, col)
    private void unmark(int value, int row, int col) {
        int blockIdx = (row / 3) * 3 + (col / 3);
        rows[row] &= ~bitFlags[value];
        cols[col] &= ~bitFlags[value];
        blocks[blockIdx] &= ~bitFlags[value];
        totalCount--;
    }
}*/