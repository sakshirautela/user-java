public class CircleandRectangleOverlapping {
    public static void main(String[] args) {
        System.out.println(checkOverlap(1, 0, 0, 1, 1, 1, 0));
    }

    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x=Math.max(x1,Math.min(x2,xCenter));
        int y=Math.max(y1,Math.min(y2,yCenter));
        int xDist=(xCenter-x);
        int yDist=(yCenter-y);
        return (xDist*xDist+yDist*yDist<=radius*radius);
    }
}
