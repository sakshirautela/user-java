public class CountNumberOfTrapozoidsII {
    public static void main(String[] args) {
        System.out.println(countTrapezoids(new int[][]{{-3, 2}, {3, 0}, {2, 3}, {3, 2}, {2, -3}}));
    }

    public static int countTrapezoids(int[][] points) {
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int ax = points[i][0], ay = points[i][1];
                        int bx = points[j][0], by = points[j][1];
                        int cx = points[k][0], cy = points[k][1];
                        int dx = points[l][0], dy = points[l][1];
                        if(ay-by==0||cy-dy==0){
                            continue;
                        }
                        int m1=(ax-bx)/(ay-by);
                        int m2=(cx-dx)/(cy-dy);
                        System.out.println(m1+" "+m2);
                    }
                }

            }
        }
        return 0;
    }
}
