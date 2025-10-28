import java.util.ArrayList;

public class RateInTheMaze {
    public static void main(String[] args) {
        System.out.println(ratInMaze(new int[][]{{}}));
    }
        public static ArrayList<String> ratInMaze(int[][] maze) {
            // code here
int n=maze[0].length;
int m=maze.length;
ArrayList<String>res=new ArrayList<>();
ratInMazeUtill(res,n,m,0,0,"",maze);
return res;
        }

    private static void ratInMazeUtill(ArrayList<String> res, int n, int m, int i, int j, String s, int[][] maze) {
        if(i==m-1&&j==n-1){
            res.add(s);
            return;
        }
        else if(i==-1||i==m||j==-1||j==n||maze[i][j]==0) {
            return;
        }
        maze[i][j]=0;
        ratInMazeUtill(res,n,m,i+1,j,s+'D',maze);
        ratInMazeUtill(res,n,m,i,j-1,s+'L',maze);
        ratInMazeUtill(res,n,m,i,j+1,s+'R',maze);
        ratInMazeUtill(res,n,m,i-1,j,s+'U',maze);
        maze[i][j]=1;
        return;
    }
}
