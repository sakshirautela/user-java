import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindaSafeWalkThroughaGrid {
    public static void main(String[] args) {
        System.out.println(findSafeWalk(new ArrayList<>(),3));
    }
    public static boolean solve(int m, int n, List<List<Integer>> grid, int health, int[][][] dp) {
        if(m==0 && n==0) {
            return health > grid.get(0).get(0);
        }

        if(m<0 || n<0 || m>=grid.size() || n>=grid.get(0).size() || health==0 || grid.get(m).get(n)==-1) return false;

        if(dp[m][n][health] != -1) {
            return dp[m][n][health] == 2;
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        int value = grid.get(m).get(n);
        grid.get(m).set(n, -1);

        boolean answer = false;
        for(int[] dir : dirs) {
            answer = answer || solve(dir[0] + m, dir[1] + n, grid, health - value, dp);
        }

        grid.get(m).set(n, value);
        dp[m][n][health] = answer ? 2 : 1;

        return answer;
    }
    public static boolean findSafeWalkDFS(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][][] dp = new int[m][n][health+1];
        for(int[][] row : dp)
            for(int[] col : row)
                Arrays.fill(col, -1);

        return solve(m-1, n-1, grid, health, dp);
    }
    public static boolean findSafeWalk2(List<List<Integer>> grid, int health) {
        int m = grid.size()-1;
        int n = grid.get(0).size()-1;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        boolean[][] visited = new boolean[m+1][n+1];
        Deque<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, health - grid.get(0).get(0)});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int curHealth = node[2];

            if(curHealth == 0)
                continue;

            if(row == m && col == n && curHealth > 0)
                return true;

            for(int[] dir : dirs) {
                int x = row+dir[0];
                int y = col+dir[1];

                if(x<0 || y<0 || x>m || y>n || visited[x][y])
                    continue;

                visited[x][y] = true;
                if(grid.get(x).get(y) == 1)
                    queue.offerLast(new int[]{x,y,curHealth-1});
                else 
                    queue.offerFirst(new int[]{x,y,curHealth});
            }
        }

        return false;
    }
    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
         int m = grid.size(); int n = grid.get(0).size();
        boolean vis[][]=new boolean[m][n];
        HashMap<String,Boolean>dp=new HashMap<>();
        return findSafeWalkUtill(grid, health,m,n,0,0,dp,vis);
    }
    private static boolean findSafeWalkUtill(List<List<Integer>> grid, int health, int m, int n, int i, int j,
            HashMap<String,Boolean> dp, boolean[][] vis) {
        if(i<0||i==m||j<0||j==n||vis[i][j]){
            return false;
        }
        health-=grid.get(i).get(j);
        if(health<=0){
            return false;
        }
        if(m-1==i && n-1==j){
            return true;
        }
        String str=i+"*"+j+"*"+health;
        if(dp.containsKey(str)){
            return dp.get(str);
        }
        boolean a=false,b=false,c=false,d=false;
        vis[i][j]=true;
        a=findSafeWalkUtill(grid, health, m, n, i-1, j,dp,vis);
        if(!a){
            b=findSafeWalkUtill(grid, health, m, n, i, j+1,dp,vis);
            if(!b){
                c=findSafeWalkUtill(grid, health, m, n, i, j-1,dp,vis);
                if(!c){
                    d=findSafeWalkUtill(grid, health, m, n, i+1, j,dp,vis);
                }
            }
        }
        vis[i][j]=false;
        dp.put(str, a|b|c|d);
        return  a|b|c|d;
    }
}