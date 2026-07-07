package problemsolvingIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumBuildingHeight {
    static void main() {
        System.out.println(maxBuilding(10, new int[][]{{5, 3}, {2, 5}, {7, 4}, {10, 3}}));
    }

    public static int maxBuilding(int n, int[][] restrictions) {
        int result = 0;
        ArrayList<int[]> heights = new ArrayList<>();
        heights.add(new int[]{1, 0});
        heights.addAll(Arrays.asList(restrictions));
        int size = heights.size();
        if (heights.get(size - 1)[0] != n) {
            heights.add(new int[]{n, n - 1});
            size++;
        }
        heights.sort(Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < size ; i++) {
            int val=heights.get(i)[0]-heights.get(i-1)[0];
            heights.get(i)[1]=Math.min(heights.get(i)[1],heights.get(i-1)[1]+val);
        }
        for (int i = size - 2;i>=0; i--) {
            int val=heights.get(i+1)[0]-heights.get(i)[0];
            heights.get(i)[1]=Math.min(heights.get(i)[1],heights.get(i+1)[1]+val);
        }
        for(int i=0;i<size-1;i++){
            int val=heights.get(i+1)[0]-heights.get(i)[0];
            result=Math.max(result, (heights.get(i+1)[1]+heights.get(i)[1]+val)/2);
        }
        return result;
    }
}
