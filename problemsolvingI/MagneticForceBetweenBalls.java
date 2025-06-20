
import java.util.Arrays;

public class MagneticForceBetweenBalls {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = (position[position.length - 1] - position[0])/(m-1);
        //int ans = 0;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (canPlace(mid, position, m)) {
                //ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //return ans;
        return high;
    }

    public static boolean canPlace(int gap, int[] position, int m) {
        int previousPos = position[0];
        int ballCount = 1;
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - previousPos >= gap) {
                ballCount++;
                previousPos = position[i];
                if (ballCount == m) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(maxDistance(new int[]{5,4,3,2,1,1000000000},2));
    }
}
