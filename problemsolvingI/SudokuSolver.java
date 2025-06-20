
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
/*class Solution {
    static boolean[][] rowUsed = new boolean[9][10];  
    static boolean[][] colUsed = new boolean[9][10];  
    static boolean[][][] boxUsed = new boolean[3][3][10]; 

    public static void solveSudoku(int[][] mat) {
        initializeUsedArrays(mat);
        sudokuSolver(mat, 0, 0);
    }

    private static void initializeUsedArrays(int[][] sudoku) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = sudoku[r][c];
                if (num != 0) {
                    rowUsed[r][num] = true;
                    colUsed[c][num] = true;
                    boxUsed[r / 3][c / 3][num] = true;
                }
            }
        }
    }

    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        if (row == 9) return true;  

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (!rowUsed[row][digit] && !colUsed[col][digit] && !boxUsed[row / 3][col / 3][digit]) {
                sudoku[row][col] = digit;
                rowUsed[row][digit] = true;
                colUsed[col][digit] = true;
                boxUsed[row / 3][col / 3][digit] = true;

                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }

                sudoku[row][col] = 0;
                rowUsed[row][digit] = false;
                colUsed[col][digit] = false;
                boxUsed[row / 3][col / 3][digit] = false;
            }
        }
        return false;
    }
}
    class Solution {
    private static final int N = 9;

    private static boolean isPossible(int[][] grid, int row, int col, int val) {
        for (int i = 0; i < N; i++) {
            if (grid[row][i] == val || grid[i][col] == val) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveSudokuHelper(int[][] grid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isPossible(grid, i, j, num)) {
                            grid[i][j] = num;
                            if (solveSudokuHelper(grid)) {
                                return true;
                            } else {
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean SolveSudoku(int[][] grid) {
        return solveSudokuHelper(grid);
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        System.out.println();
    }
}
    CLASS gfg{
static boolean isSafe(int[][] mat, int row, int col, int num) {
        for (int x = 0; x < 9; x++)
            if (mat[row][x] == num)
                return false;

        for (int x = 0; x < 9; x++)
            if (mat[x][col] == num)
                return false;

        int startRow = row - (row % 3), startCol = col - (col % 3);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (mat[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

    // Function to solve the Sudoku problem
    static boolean solveSudokuRec(int[][] mat, int row, int col) {
      
        if (row == 8 && col == 9)
            return true;
        if (col == 9) {
            row++;
            col = 0;
        }
        if (mat[row][col] != 0)
            return solveSudokuRec(mat, row, col + 1);

        for (int num = 1; num <= 9; num++) {
            if (isSafe(mat, row, col, num)) {
                mat[row][col] = num;
                if (solveSudokuRec(mat, row, col + 1))
                    return true;
                mat[row][col] = 0;
            }
        }

        return false;
    }

    static void solveSudoku(int[][] mat) {
        solveSudokuRec(mat, 0, 0);
    }
 */
