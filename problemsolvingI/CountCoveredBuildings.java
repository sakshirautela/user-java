import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountCoveredBuildings {
    public static void main(String[] args) {
        System.out.println(new CountCoveredBuildings().countCoveredBuildings(5, new int[][] { { 1,2 }, { 2,2 }, { 3, 2 },{2,1},{2,3} }));//1,2],[2,2],[3,2],[2,1],[2,3
    }
    public  int countCoveredBuildings(int n, int[][] arr) {
        n = n + 1;
        int min_x_for_y[] = new int[n];
        Arrays.fill(min_x_for_y , Integer.MAX_VALUE);
        int max_x_for_y[] = new int[n];
         Arrays.fill(max_x_for_y , Integer.MIN_VALUE);
        int min_y_for_x[] = new int[n];
        Arrays.fill(min_y_for_x , Integer.MAX_VALUE);
        int max_y_for_x[] = new int[n];
         Arrays.fill(max_y_for_x , Integer.MIN_VALUE);

        for(int i [] : arr) {
            int x = i[0];
            int y = i[1];

            min_x_for_y[y] = Math.min(min_x_for_y[y] , x);
            max_x_for_y[y] = Math.max(max_x_for_y[y] , x);
            min_y_for_x[x] = Math.min(min_y_for_x[x] , y);
            max_y_for_x[x] = Math.max(max_y_for_x[x] , y);
        }

        int result = 0 ; 
        for(int i[] : arr)  {
            int x = i[0];
            int y = i[1];

            if(min_x_for_y[y] < x && max_x_for_y[y] > x && min_y_for_x[x] < y && max_y_for_x[x] > y ) {
                result++;
            }
        }

        return result;
    }
    public int countCoveredBuildings2(int n, int[][] buildings) {
        HashMap<Integer, int[]> xmap = new HashMap<>();
        HashMap<Integer, int[]> ymap = new HashMap<>();
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            xmap.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            xmap.get(y)[0]=Math.min(xmap.get(y)[0],x);
            xmap.get(y)[1]=Math.max(xmap.get(y)[1],x);
            ymap.putIfAbsent(x,  new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            ymap.get(x)[0]=Math.min(ymap.get(x)[0],y);
            ymap.get(x)[1]=Math.max(ymap.get(x)[1],y);
        }
        int count = 0;
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            if(xmap.get(y)[0]<x && xmap.get(y)[1]>x &&ymap.get(x)[0]<y &&ymap.get(x)[1]<y){
                count++;
            }
        }
        return count;
    }
    public int countCoveredBuildingsClear(int n, int[][] buildings) {
        if (n <= 4) return 0;

        // Maps to track the range of x for each y (row), and y for each x (column)
        Map<Integer, int[]> xRangeForY = new HashMap<>();
        Map<Integer, int[]> yRangeForX = new HashMap<>();

        // Build range maps
        for (int[] building : buildings) {
            int x = building[0], y = building[1];

            // For row y: track min and max x
            xRangeForY.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            xRangeForY.get(y)[0] = Math.min(xRangeForY.get(y)[0], x);
            xRangeForY.get(y)[1] = Math.max(xRangeForY.get(y)[0], x);

            // For column x: track min and max y
            yRangeForX.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            int[] yRange = yRangeForX.get(x);
            yRange[0] = Math.min(yRange[0], y);
            yRange[1] = Math.max(yRange[1], y);
        }

        int count = 0;

        // Count buildings that are not on the boundary of their row or column
        for (int[] building : buildings) {
            int x = building[0], y = building[1];

            int[] xRange = xRangeForY.get(y);
            int[] yRange = yRangeForX.get(x);

            if (xRange[0] < x && x < xRange[1] &&
                yRange[0] < y && y < yRange[1]) {
                count++;
            }
        }

        return count;
    }
}