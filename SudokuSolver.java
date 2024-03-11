public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = {{1,0,0,0,0,0,0,0,0}, { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0 }};
        if (sudokuSolver(sudoku, 0, 0)) {
            printSudoku(sudoku);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }

    private static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.println(sudoku[i][j]);
            }
            System.out.println();

        }
    }

    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        if (row == 9) {
            return true;
        }
        int newCol = col;
        int newRow = row;
        if (newRow == 9) {
            newCol++;
            newRow = 0;
        }
        if (sudoku[newRow][newCol] == 0) {
            for (int digit = 0; digit < 9; digit++) {
                if (isSafe(sudoku, row, col, digit)) {
                    sudoku[row][col] = digit;
                    if (sudokuSolver(sudoku, newRow, newCol)) {
                        return true;
                    }
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        for (int i = 0; i < col; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        for (int i = 0; i < row; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // grid
        int sc = col / 3;
        int sr = row / 3;
        for (int i = 0; i < sc + 3; i++) {
            for (int j = 0; j < sr + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
}
