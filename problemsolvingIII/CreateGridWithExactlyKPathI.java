package problemsolvingIII;

public class CreateGridWithExactlyKPathI {
    static void main() {
        String[] res = createGrid( 3, 3,4);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static String[] createGrid(int m, int n, int k) {
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
                if (i == 0 || j == n - 1) {
                    grid[i][j] = '.';
                }
            }
        }
        k--;
        for (int i = 1; i < m && k>0 ; i++) {
            for (int j = n - 2; j >= 0 && k>0; j--) {
                grid[i][j] = '.';
                k--;
            }
        }
        String[] res = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
            }
            res[i] = sb.toString();
        }
        return res;
    }
}
