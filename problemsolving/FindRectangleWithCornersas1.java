import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class FindRectangleWithCornersas1 {
    public static void main(String[] args) {
        System.out.println(ValidCorner(new int[][] { {} }));
    }

    public static boolean ValidCorner(int mat[][]) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < m; k++) {
                    if (mat[i][k] == 0) {
                        continue;
                    }
                    if(hs.contains(j+","+k)){
                        return true;
                    }
                    hs.add(j+","+k);
                }
            }

        }
        return false;
    }
 
    static boolean ValidCorner2(int[][] mat) {
        
        List<List<Short>> rows = new ArrayList<>();
        int N = 0;
        
        // Preprocess: Store columns with 1s for each row
        for (int[] row : mat) {
            List<Short> cols = new ArrayList<>();
            for (short c = 0; c < row.length; ++c) {
                if (row[c] == 1) cols.add(c);
            }
            rows.add(cols);
            N += cols.size();
        }

        int sqrtN = (int)Math.sqrt(N);
        Set<Integer> pairs = new HashSet<>();

        for (int r = 0; r < rows.size(); ++r) {
            if (rows.get(r).size() >= sqrtN) {
                // Dense row: Check against all previous rows
                Set<Short> cols = new HashSet<>(rows.get(r));
                for (int r2 = 0; r2 < r; ++r2) {
                    int common = 0;
                    for (short c : rows.get(r2)) {
                        if (cols.contains(c)) {
                            common++;
                            // Early exit
                            if (common >= 2) return true; 
                        }
                    }
                }
            } else {
                // Sparse row: Check column pairs
                List<Short> row = rows.get(r);
                for (int i = 0; i < row.size(); ++i) {
                    for (int j = i + 1; j < row.size(); ++j) {
                        int key = (row.get(i) << 13) | row.get(j);
                        if (pairs.contains(key)) return true;
                        pairs.add(key);
                    }
                }
            }
        }
        return false;
    }
}