import java.util.Arrays;

public class FindtheNumberofWaystoPlacePeopleI {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[][]{{0,0},{0,3}}));
    }

    public static int numberOfPairs(int[][] points) {
        int result=0;
        Arrays.sort(points,(a, b)->(a[0]==b[0])?b[1]-a[1]:a[0]-b[0]);
        int n=points.length;
        for (int i = 0; i < n; i++) {
            int[] a=points[i];
            int y=-1;
            for (int j = i+1; j < n; j++) {
                int[] b=points[j];
                if(a[0]<=b[0]&&a[1]>=b[1]&&y<b[1]){
                    result++;
                    y=Math.max(b[1],y);
                }
            }
        }
        return result;
    }
}
