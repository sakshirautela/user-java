import java.util.Arrays;

public class MinimizeTheHeightII {
    public static void main(String[] args) {
        System.out.println(getMinDiff(new int[]{1, 5, 8, 10},2));
    }
    public static int getMinDiff(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int max=arr[n-1];
        int min=arr[0];
        int res=max-min;
        for (int i = 1; i <n ; i++) {
            if(arr[i]<k){
                continue;
            }
            min=Math.min(arr[i]-k,arr[0]+k);
            max=Math.max(arr[i-1]+k,arr[n-1]-k);
            res=Math.min(res,max-min);
        }
        return res;
    }
}
