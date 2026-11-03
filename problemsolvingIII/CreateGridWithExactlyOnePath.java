package problemsolvingIII;

public class CreateGridWithExactlyOnePath {
    static void main() {
        String[] res = createGrid(2, 3);
    }

    public static String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        StringBuilder sb = new StringBuilder();
        sb.append('.');
        for (int j = 1; j < n; j++) {
            sb.append('#');
        }
        for (int i = 0; i < m - 1; i++) {
            grid[i] = sb.toString();
        }
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < n; j++) {
            s.append('.');
        }
        grid[m - 1] = s.toString();
        return grid;
    }
}
