import java.util.ArrayList;

public class PrintDiagonally {
    static void main() {
        System.out.println(diagView(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        int n = mat.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            int i = 0;
            for (int j = k; j >= 0; j--) {
                res.add(mat[i][j]);
                i++;
            }
        }
        for (int k = 1; k < n; k++) {
            int i = k;
            for (int j = n-1; j >= 0 && i<n; j--) {
                res.add(mat[i][j]);
                i++;
            }
        }
        return res;
    }
}
