import java.util.Arrays;

public class minimizeTheHight {

    public static void main(String[] args) throws Exception {
            System.out.println(getMinDiff(new int[]{6, 9, 7, 4, 4, 7, 1, 8, 10, 5},10,4));
    }
    static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int min=arr[0],max=arr[n-1];
        int res=max-min;
        for (int i = 1; i < arr.length; i++) {
            min=Math.min(arr[i]-k,arr[0]+k);
            max=Math.max(arr[i-1]+k,arr[n-1]-k);
            res=Math.min(res, max-min);
        }
        return res;
    }
}
