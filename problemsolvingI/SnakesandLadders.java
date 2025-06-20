import java.util.Queue;
import java.util.LinkedList;

public class SnakesandLadders {
    public static void main(String[] args) {
        System.out.println(snakesAndLaddersBFS(new int[][] { {} }));
    }
    public int snakesAndLadders(int[][] board) {
        // Brute force, go left to right, right to left
        // create a queue for each position
        // check if not -1 add the destination, else add pos
        // set visited true
        // for each q traverse update move++ as 6 steps can be taken;
        // keep taking either 6 steps/ snakes and ladders
        // first time encountering n*n pos is the answer;

        // int n = board.length;
        // boolean[][] visited = new boolean[n][n];
        // Deque<Integer> q = new ArrayDeque<>();

        // //non flatten approach
        // q.offer(1);
        // visited[n-1][0]=true;
        // int minSteps=0;

        // while(!q.isEmpty()){
        //     int size = q.size();
        //     while(size-- >0){
        //         int currPos = q.poll();
        //         //check if nextPos reaches the target:
        //         if (currPos==n*n) {return minSteps;}

        //         for(int diceRoll=1;diceRoll<=6;diceRoll++){
        //             int nextPos = currPos + diceRoll;
        //             // find the row, col for nextPos
        //             if(nextPos > n*n) {continue;}
        //             int[] pos = findCoordinate(nextPos,n);
        //             int r = pos[0];
        //             int c = pos[1];

        //             if(visited[r][c]!=true){
        //                 visited[r][c]=true;
        //                 if(board[r][c]!=-1){
        //                     q.add(board[r][c]);
        //                 }else{
        //                     q.add(nextPos);
        //                 }
        //             }

        //         }
        //     }
        //     minSteps++;
        // }

        // return -1;

        
        // using array as queue
        int n = board.length;
        int endPos = n*n;

        // flatten board into an array
        short[] brd = new short[endPos+1];
        int brdPos = 1;
    
        for(int row=n-1;row>=0;row--){
            for(int col=0;col<n;col++){
                brd[brdPos++]= (short) board[row][col];
            }
            if(--row <0) { break;}
            for(int col=n-1;col>=0;col--){
                brd[brdPos++]=(short) board[row][col];
            }
        }

        short[] bfsQ = new short[n*n];
        int bfsQRead=0, bfsQWrite=0;
        bfsQ[bfsQWrite++]=1;
        int[] moves = new int[endPos+1];
        moves[1] = 1;

        while(bfsQRead!=bfsQWrite){
            int currPos = bfsQ[bfsQRead++];
            bfsQRead %= endPos;

            if(currPos + 6 >= endPos ){
                return moves[currPos];
            }
            int maxMove = 0;
            for(int diceRoll=6;diceRoll>=1;diceRoll--){
                int nextPos = currPos + diceRoll;

                if(brd[nextPos]>=0){
                    nextPos = brd[nextPos];
                    if(nextPos==endPos){
                        return moves[currPos];
                    }
                }else{
                    if(diceRoll < maxMove){
                        continue;
                    }
                    maxMove = diceRoll;
                }

                if(moves[nextPos]==0){
                    moves[nextPos]= moves[currPos]+1;
                    bfsQ[bfsQWrite++]=(short) nextPos;
                    bfsQWrite %= endPos;

                    if(bfsQRead==bfsQWrite){
                        return 0;
                    }
                }
            }

        }

        return -1;
    }

    // private int[] findCoordinate(int val,int n){
    //    int r = (n-1)-(val-1)/n;
    //    int c = (val-1)%n;

    //    if(r%2==n%2){
    //     return new int[]{r,n-1-c};
    //    }

    //    return new int[]{r,c};
    // }
    
    public static int snakesAndLaddersBFS(int[][] board) {
        int n = board.length;
        int[] game = new int[n * n + 1];
        int idx = 1;
        boolean leftToRight = true;

        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    game[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    game[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        q.offer(1);
        visited[1] = true;
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == n * n) return moves;
                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    if (game[next] != -1) next = game[next];
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
    public static int snakesAndLaddersDFS(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        int result = snakesAndLaddersUtil(board, 1, 0, n,visited);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    private static int snakesAndLaddersUtil(int[][] board, int curr, int steps, int n, boolean[] visited) {
        if (curr == n * n) {
            return steps;
        }
        visited[curr] = true;
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= 6 && curr + k <= n * n; k++) {
            int next = curr + k;
            int quot = (next - 1) / n;
            int rem = (next - 1) % n;
            int row = n - 1 - quot;
            int col = row % 2 == n % 2 ? rem : n - 1 - rem;
            if (board[row][col] != -1) {
                next = board[row][col];
            }
           if (!visited[next]) {
                res = Math.min(res, snakesAndLaddersUtil(board, next, steps + 1, n, visited));
            }
        }
        visited[curr] = false;
        return res;
    }
}