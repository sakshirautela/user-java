public class MatrixSimilarityAfterCyclicShifts {
    static void main() {
        System.out.println(areSimilar(new int[][]{}, 4));
    }

    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k %= n;

        for (int[] ints : mat) {
            for (int j = 0; j < n; j++) {
                if (ints[j] != ints[(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
