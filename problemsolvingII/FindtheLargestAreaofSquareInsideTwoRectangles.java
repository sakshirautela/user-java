public class FindtheLargestAreaofSquareInsideTwoRectangles {
    static void main() {
        System.out.println(largestSquareArea(new int[][]{}, new int[][]{}));
    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long area=0;
        for (int i = 0; i < n; i++) {
            int x11 = bottomLeft[i][0], y11 = bottomLeft[i][1];
            int x12 = topRight[i][0], y12 = topRight[i][1];

            for (int j = i + 1; j < n; j++) {
                int x21 = bottomLeft[j][0], y21 = bottomLeft[j][1];
                int x22 = topRight[j][0], y22 = topRight[j][1];

                int l = Math.max(0, Math.min(x12, x22) - Math.max(x11, x21));
                int m = Math.max(0, Math.min(y12, y22) - Math.max(y11, y21));

                long side=Math.min(l,m);
                area=Math.max(area,side*side);
            }
        }
        return area;
    }
}