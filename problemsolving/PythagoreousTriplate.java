
import java.util.HashMap;

public class PythagoreousTriplate {
    static boolean checkTriplet(int[] arr, int n) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i] * arr[i], i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (hm.containsKey(arr[i] * arr[j]) && hm.get(arr[i]) != i && hm.get(arr[j]) != j) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(checkTriplet(new int[]{}, 5));
    }
}
