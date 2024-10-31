public class ValidateSudoku {
    public static boolean isValidSudoku(String[][] board) {
        int n=board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j].equals(".")){
                    continue;
                }
                if(!isValied(n,i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValied(int n,int i, int j, String[][] board) {
        for(int s=0;s<n;s++){
            if(board[i][s]==board[i][j] && j!=s){
                return false;
            }
            if(board[s][j]==board[i][j] && s!=i){
                return false;
            }
        }
        int sr=(i/3)*3;
        int sc=(j/3)*3;
        for(int s=sr;s<sr+3;s++){
            for(int t=sc;t<sc+3;t++){
                if(board[i][j]==board[s][t] && s!=i && j!=t){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(isValidSudoku(new String[][]{{"5","3",".",".","7",".",".",".","."}
,{"6",".",".","1","9","5",".",".","."}
,{".","9","8",".",".",".",".","6","."}
,{"8",".",".",".","6",".",".",".","3"}
,{"4",".",".","8",".","3",".",".","1"}
,{"7",".",".",".","2",".",".",".","6"}
,{".","6",".",".",".",".","2","8","."}
,{".",".",".","4","1","9",".",".","5"}
,{".",".",".",".","8",".",".","7","9"}}));
    }
}