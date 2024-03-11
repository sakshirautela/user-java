class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int dp[][] = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int c=0;
                if(i>0 && i<board.length-1 && j>0 && j<board[i].length-1){
                    c+=board[i][j-1]+board[i-1][j]+board[i+1][j+1]+board[i+1][j]+board[i][j+1]+board[i-1][j-1]+board[i+1][j-1]+board[i-1][j+1];
                }
                if(i==0 && i<board.length-1 && j>0 && j<board[i].length-1){
                    c+=board[i][j-1]+board[i+1][j+1]+board[i+1][j]+board[i][j+1]+board[i+1][j-1];
                }
                if(i>0 && i<board.length-1 && j==0 && j<board[i].length-1){
                    c+=board[i-1][j]+board[i+1][j+1]+board[i+1][j]+board[i][j+1]+board[i-1][j+1];
                }
                if(i>0 && i==board.length-1 && j>0 && j<board[i].length-1){
                    c+=board[i][j-1]+board[i-1][j]+board[i][j+1]+board[i-1][j-1]+board[i-1][j+1];
                }
                if(i>0 && i<board.length-1 && j>0 && j==board[0].length-1){
                    c+=board[i][j-1]+board[i-1][j]+board[i+1][j]+board[i-1][j-1]+board[i+1][j-1];
                }
                dp[i][j] = c;
                // if(c>3){
                //     dp[i][j]=(board[i][j]==1)?true:false;
                // }
                // else if(c<=2 && c>0){
                //     dp[i][j]=(board[i][j]==1)?true:false;
                // }
                // else if(c==3){
                //     dp[i][j]=(board[i][j]==0)?true:false;;
                // }
            }
        }
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length;j++){
                // if(dp[i][j]){
                //     board[i][j]=0;
                // }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        } 
    }
    public static void main(String[] args){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("nxt");
        gameOfLife(board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}