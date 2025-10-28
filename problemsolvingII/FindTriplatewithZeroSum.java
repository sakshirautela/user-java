import java.util.Arrays;
import java.util.HashMap;

public class FindTriplatewithZeroSum {
    public static void main(String[] args) {
        System.out.println(findTriplets(new int[]{}));
    }
    public static boolean findTriplets(int[] arr) {
        // code here.
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            map.put(arr[i],i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                int rem = arr[i] + arr[j];
                if (map.containsKey(-rem) && map.get(-rem) != i && map.get(-rem) != j) {
                    return true;
                }
            }
        }
        return false;
    }
}