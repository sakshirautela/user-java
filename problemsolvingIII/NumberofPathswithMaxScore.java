package problemsolvingIII;

import java.util.*;

public class NumberofPathswithMaxScore {
    public static void main(String[] args) {
        int[] res = pathsWithMaxScore(new ArrayList<>(Arrays.asList("E23", "2X2", "12S")));
        System.out.println(res[0]+" "+res[1]);
    }

    public static int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] sum = new int[n][n];
        int[][] path = new int[n][n];
        boolean[][]  visited = new boolean[n][n];
        pathsWithMaxScoreUtil(n - 1, n - 1, sum, path, board,visited);
        if (path[n - 1][n - 1] == 0) {
            return new int[]{0, 0};
        }
        return new int[]{sum[n - 1][n - 1], path[n - 1][n - 1]};
    }
    static int MOD = 1_000_000_007;
    static int[][] dir = {{-1, -1}, {0, -1}, {-1, 0}};
    private static void pathsWithMaxScoreUtil(int i, int j, int[][] sum, int[][] path, List<String> board, boolean[][] visited) {
        if (i < 0 || j < 0 || board.get(i).charAt(j) == 'X') {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        char c = board.get(i).charAt(j);
        if (c == 'X') {
            sum[i][j] = 0;
            path[i][j] = 1;
            return;
        }
        if(i==0 && j==0){
            sum[i][j] = 0;
            path[i][j] = 1;
            return;
        }
        int count=0;
        int max=-1;
        for(int[] d:dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x<0 || y<0){
                continue;
            }
            pathsWithMaxScoreUtil(x,y,sum,path,board, visited);
            if(sum[x][y]>max){
                max=sum[x][y];
                count=path[x][y];
            }else if(sum[x][y]==max){
                count+=path[x][y];
            }
        }
        if(max==-1){
            path[i][j] = 0;
            sum[i][j] = -1;
            return;
        }
        int values=0;
        if(c!='S'){
            values=c-'0';
        }
        sum[i][j]=max+values;
        path[i][j]=(count%MOD);
    }

    public static int[] pathsWithMaxScore2(List<String> board) {

        int[][] dir = {{-1, -1}, {0, -1}, {-1, 0}};
        HashMap<Integer, Integer> f = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        int[] res = new int[2];
        int n = board.size();
        q.offer(new int[]{n - 1, n - 1, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == 0 && curr[1] == 0) {
                f.put(curr[2], f.getOrDefault(curr[2], 0) + 1);
            }
            for (int[] d : dir) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                if (x == 0 && y == 0) {
                    f.put(curr[2], f.getOrDefault(curr[2], 0) + 1);
                }
                ;
                if (x >= 0 && y >= 0 && board.get(x).charAt(y) != 'X') {
                    int score = curr[2] + (board.get(x).charAt(y) - '0');
                    System.out.println(board.get(x).charAt(y));
//                    System.out.println(x+" "+y+" "+score);
                    q.offer(new int[]{x, y, score});
                }
            }
        }
        System.out.println(f);
        return res;
    }
}