
public class MaximumManhattanDistanceAfterKChanges {
    public static void main(String[] args) {
        System.out.println(maxDistance("NWSE", 1));
    }

    public static int maxDistance(String s, int k) {
        int dist = 0;
        int y = 0, x = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'S') {
                y -= k;
            } else if (ch == 'W') {
                x -= k;
            }else if (ch == 'N') {
                y += k;
            } else{
                x += k;
            }
            dist=Math.max(dist,Math.abs(x-y));
        }
        return dist;
    }
}
