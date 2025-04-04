import java.util.Arrays;

public class CheckifGridcanbeCutintoSections {
    public static void main(String[] args) {
        System.out.println(checkValidCuts(0, new int[][] { {} }));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        int len = rectangles.length;
        int[][] x = new int[len][2];
        int[][] y = new int[len][2];
        for (int i = 0; i < len; i++) {
            x[i][0] = rectangles[i][0];
            x[i][1] = rectangles[i][2];
            y[i][0] = rectangles[i][1];
            y[i][1] = rectangles[i][3];
        }
        Arrays.sort(x, (a, b) -> a[0] - b[0]);
        Arrays.sort(y, (a, b) -> a[0] - b[0]);
        return Math.max(checkValidCutsHelper(x), checkValidCutsHelper(y)) >= 3;
    }

    private static int checkValidCutsHelper(int[][] rectangles) {
        int count = 0;
        int prevEnd = -1;
        for (int i[] : rectangles) {
            int start = i[0];
            int end = i[1];
            if (prevEnd <= start) {
                count++;
            }
            prevEnd = Math.max(prevEnd, end);
        }
        return count;
    }

    private static final int MASK = (1 << 30) - 1;

    public boolean checkValidCuts2(int m, int[][] rectangles) {
        int n = rectangles.length;
        long[] start = new long[n];
        for (int i = 0; i < n; i++) {
            start[i] = ((long) rectangles[i][1] << 32) + rectangles[i][3];
        }
        Arrays.sort(start);
        if (validate(start)) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            start[i] = ((long) rectangles[i][0] << 32) + rectangles[i][2];
        }
        Arrays.sort(start);
        return validate(start);
    }

    private boolean validate(long[] arr) {
        int cut = 0;
        int n = arr.length;
        int max = (int) arr[0] & MASK;
        for (int i = 0; i < n; i++) {
            int start = (int) (arr[i] >> 32);
            if (start >= max && ++cut == 2) {
                return true;
            }
            max = Math.max(max, (int) (arr[i] & MASK));
        }
        return false;
    }
}