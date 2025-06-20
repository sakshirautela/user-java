public class SudokuSolverLeetcode {
    public static void main(String[] args) {
        char board[][]={{}};
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
        solveSudoku(board);
        System.out.println("After solving sudoku");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
    public boolean isValid(int i,int j,char[][] board){
        return true;
    }
    public static void solveSudoku(char[][] board) {
        
    }
}