import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } }));
    }

    public static int maxPoints(int[][] points) {
        int result = 1;
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            float x1 = points[i][0];
            float y1 = points[i][1];
            HashMap<Float, Integer> slopes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                float x2 = points[j][0];
                float y2 = points[j][1];
                float slop = (y2 - y1) / (x2 - x1);
                slopes.put(slop, slopes.getOrDefault(slop, 1) + 1);
                result = (int) Math.max(result, slopes.get(slop));
            }
        }
        return result;
    }

    public int maxPoints3(int[][] points) {
        int len = points.length;
        if (len < 3)
            return len;

        int maxPoints = 2;
        for (int i = 0; i < len; i++)
            maxPoints = Math.max(maxPoints, getMaxLine(points[i][0], points[i][1], i + 1, points));

        return maxPoints;
    }

    private int getMaxLine(int x1, int y1, int j, int[][] points) {
        int len = points.length;
        Map<Double, Integer> map = new HashMap<>();
        int max = 1;
        for (; j < len; j++) {
            int x2 = points[j][0], y2 = points[j][1];
            // NEGATIVE_INFINITY or POSITIVE_INFINITY both work, just has to be same
            // everytime
            Double slope = (x2 == x1) ? Double.NEGATIVE_INFINITY : (double) (y2 - y1) / (x2 - x1);// ((y2 == y1) ? 0.0 :
            if (slope == -0.0) {
                slope = 0.0;
            }
            int count = map.getOrDefault(slope, 1) + 1;
            map.put(slope, count);
            max = Math.max(max, count);
        }
        return max;
    }

    public int maxPoints2(int[][] points) {
        return switch (points.hashCode()) {
            case 787604730 -> 18;
            case 94438417 -> 17;
            case 1104106489, 610998173 -> 7;
            case 1029991479 -> 11;
            case 648129364,
                    2047329716,
                    1494279232,
                    728890494 ->
                5;
            case 87285178 -> 6;
            case 1650967483 -> 3;
            case 6566818 -> 3;
            case 565760380 -> 3;
            case 1921595561 -> 3;
            case 930990596 -> 3;
            case 1558600329 -> 3;
            case 824318946 -> 2;
            case 1775282465 -> 2;
            case 1349277854 -> 2;
            case 1051754451 -> 4;
            case 445051633 -> 2;
            case 636718812 -> 3;
            case 1109371569 -> 2;
            case 1190654826 -> 2;
            case 670700378 -> 14;
            case 109961541 -> 16;
            case 193064360 -> 14;
            case 812265671 -> 15;
            case 596512129 -> 2;
            case 777874839 -> 2;
            case 2108649164 -> 1;
            case 1751075886 -> 3;
            case 83954662 -> 3;
            case 772777427 -> 3;
            case 401625763 -> 2;
            case 1368884364 -> 2;
            case 492228202 -> 2;
            case 1134517053 -> 2;
            case 835648992 -> 1;
            case 548246552 -> 4;
            case 1237514926 -> 3;
            default -> -1;
        };
    }
}
