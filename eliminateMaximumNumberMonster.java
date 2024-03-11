import java.util.Arrays;

public class eliminateMaximumNumberMonster {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int[][] arr = new int[dist.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = dist[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        int count = 0;
        for (int i = 0; i < dist.length; i++) {
            System.err.println(arr[i][0]+" "+arr[i][1]+","+i);
            if ((arr[i][0] - (arr[i][1] * i)) <= 0) {
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(helper(new int[]{ 3, 5, 7, 4, 5},new int[]{ 2, 3, 6, 3, 2}));
    }
    public static int helper(int[] dist,int[] speed){
                float[] time = new float[dist.length];
                for (int i = 0; i < time.length; i++) {
                    time[i] = (float)dist[i] / speed[i];
                }
                Arrays.sort(time);
                for (int i = 0; i < time.length; i++) {
                    System.out.println(time[i]);
                    if (time[i]-i <= 0) {
                        return i;
                    }
                }
                return time.length;
            }
}
