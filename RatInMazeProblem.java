import java.util.ArrayList;

public class RatInMazeProblem {
    public static ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> al = new ArrayList<String>();
        findPathHelper(mat, al, 0, 0, "");
        if (al.size() == 0) {
            al.add("-1");
        }
        return al;
    }

    private static void findPathHelper(int[][] mat, ArrayList<String> al, int i, int j, String s) {
        if (i < 0 || j >= mat[0].length || i >= mat[0].length || j < 0 || mat[i][j] == 0) {
            return;
        }
        if (i == mat.length - 1 && j == mat[0].length - 1 && mat[i][j] == 1) {
            al.add(s);
            return;
        }
        mat[i][j]=0;
        findPathHelper(mat, al, i, j + 1, s + "R");
        findPathHelper(mat, al, i + 1, j, s + "D");
        mat[i][j]=1;
    }

    public static void main(String[] args) {
        System.out.println(findPath(new int[][] { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } }));
    }

}