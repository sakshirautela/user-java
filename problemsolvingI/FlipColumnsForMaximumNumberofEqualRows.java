
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberofEqualRows {
    public static void main(String args[]) {
        System.out.println(maxEqualRowsAfterFlips(new int[][] { { 0, 1 }, { 1, 0 } }));
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            StringBuilder s = new StringBuilder();
            StringBuilder f = new StringBuilder();
            for (int j : matrix[i]) {
                s.append((j == 0) ? '0' : '1');
                f.append((j == 0) ? '1' : '0');
            }
            hs.put(s.toString(), hs.getOrDefault(s.toString(), 0) + 1);
            hs.put(f.toString(), hs.getOrDefault(f.toString(), 0) + 1);
        }
        int max = 0;
        System.err.println(hs);
        for (int s : hs.values()) {
            max = Math.max(max, s);
        }
        return max;
    }

    public int maxEqualRowsAfterFlips2(int[][] mat) {
        HashMap<String, Integer> patFreq = new HashMap<>();

        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row)
                    pattern.append(bit);
            } else {
                for (int bit : row)
                    pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }

        return Collections.max(patFreq.values());
    }

    public int maxEqualRowsAfterFlips3(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] ^= matrix[i][m - 1];
                }
            }
            res = Math.max(res, map.merge(Arrays.hashCode(matrix[i]), 1, Integer::sum));

        }
        return res;
    }
}
