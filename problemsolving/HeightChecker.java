import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] result = Arrays.copyOf(heights, heights.length);
        Arrays.sort(result);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            System.out.println(heights[i]+" "+result[i]);
            if (result[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.print(heightChecker(new int[] {1,3,4,2,3,1}));
    }
}
