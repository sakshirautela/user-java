import java.util.Arrays;

public class SeparateSquareII {
    static void main() {
        System.out.println(separateSquares(new int[][]{{0,0,2},{1,1,1}}));
    }

    public static double separateSquares(int[][] squares) {
        double max_y = 0;
        Arrays.sort(squares,(a,b)->a[0]-b[0]);
        double total_area = 1.0*squares[0][2]*squares[0][2];
        for (int i=1;i<squares.length;i++) {
            int[] square=squares[i];
            max_y = Math.max(max_y, square[1] + square[2]);
            total_area += 1.0 * square[2] * square[2];
            total_area-=overlayArea(square,squares[i-1]);
        }
        double low = 0, high = max_y;
        double eps = 1e-5;

        while (high - low > eps) {
            double mid = (low + high) / 2;
            if (check(mid, total_area, squares)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private static double overlayArea(int[] a, int[] b) {
return Math.max(0,Math.min(a[1]+a[2], b[1]+b[2])-Math.max(a[0],b[0]));
    }

    private static boolean check(double max_y, double totalArea, int[][] squares) {
        double area = 0;
        for (int[] square : squares) {
            if (square[1] < max_y) {
                area += square[2] * Math.min(max_y - square[1], square[2]);
            }
        }
        return area >= totalArea / 2;
    }
}

