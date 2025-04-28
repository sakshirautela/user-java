package com.learn.java.problemsolving;

public class NumberOfIslands {
    public static int numIslands(String[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j].equals("1")){
                    dfs(grid,visited,i,j,m,n);
                    res++;
                }
            }
        }
        return res;
    }
    private static void dfs(String[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n ||visited[i][j]|| grid[i][j].equals("0")){
            return ;
        }
        visited[i][j]=true;
        dfs(grid,visited,i+1,j,m,n);
        dfs(grid,visited,i-1,j,m,n);
        dfs(grid,visited,i,j+1,m,n);
        dfs(grid,visited,i,j-1,m,n);

    }
    public static void main(String args[])
    {
        System.out.println(numIslands(new String[][]{{"1","1","1","1","0"},
                                                    {"1","1","0","1","0"},
                                                    {"1","1","0","0","0"},
                                                    {"0","0","0","0","0"}}));
    }
}