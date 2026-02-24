import java.util.ArrayList;
import java.util.HashMap;

public class CountSubarrayWithGivenXOR {
    static void main() {
        System.out.println(subarrayXor(new int[]{4, 2, 2, 6, 4},6));
        System.out.println();
    }
    public static long subarrayXor(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int xor=0;
        int res=0;
        for (int j : arr) {
            xor ^= j;
            if (j == k) {
                res++;
            }
            if (xor == k) {
                res++;
            }
            list.add(xor);
        }
        System.out.println(list);
        return res;
    }
}