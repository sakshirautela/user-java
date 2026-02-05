public class SeparateSquare1 {
    static void main() {

    }

    public static double separateSquares(int[][] squares) {
        double max_y = 0;
        double total_area = 0;

        for (int[] square : squares) {
            max_y = Math.max(max_y, square[1] + square[2]);
            total_area += 1.0 * square[2] * square[2]; // FIX
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

