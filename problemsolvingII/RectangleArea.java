public class RectangleArea {
    static void main() {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int mod = (int) (10e9 + 7);
        int area = ((by2 - by1) * (bx2 - bx1)) % mod;
        area = (area + (((ay2 - ay1) * (ax2 - ax1)) % mod)) % mod;
        int l=Math.max(0,(Math.min(ax2,bx2)-Math.max(ax1,bx1)));
        int m=Math.max(0,(Math.min(ay2,by2)-Math.max(ay1,by1)));
        area = (area - ((l * m) % mod)) % mod;

        return area;
    }

}