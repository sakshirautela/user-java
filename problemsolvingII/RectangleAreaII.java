import java.util.Arrays;

public class RectangleAreaII {
    static void main() {
        System.out.println(rectangleArea(new int[][]{}));
    }
        public static int rectangleArea(int[][] rectangles) {
            Arrays.sort(rectangles,(a,b)->(a[0]-b[0]));
            int x1=0,y1=0,x2=0,y2=0;

            return 0;
        }
    public static int isRectangleOverlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int mod = (int) (10e9 + 7);
            int area = ((by2 - by1) * (bx2 - bx1)) % mod;
            area = (area + (((ay2 - ay1) * (ax2 - ax1)) % mod)) % mod;
            int l=Math.max(0,(Math.min(ax2,bx2)-Math.max(ax1,bx1)));
            int m=Math.max(0,(Math.min(ay2,by2)-Math.max(ay1,by1)));
            area = (area + ((l * m) % mod)) % mod;

            return area;
        }
/*public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

    if (rec1[0]>=rec2[2] || rec2[0]>=rec1[2]) return false;
    if (rec1[1]>=rec2[3] || rec2[1]>=rec1[3]) return false;
    return true;
}*/
}
