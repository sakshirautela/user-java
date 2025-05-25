import java.util.Arrays;
import java.util.HashSet;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        System.err.println(pythagoreanTriplet(new int[] { 3, 2, 4, 6, 5 }));
    }

    static boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(arr[i] * arr[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (hs.contains(arr[i] * arr[i] + arr[j] * arr[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean pythagoreanTripletWrong(int[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        for (int index = 0; index < n; index++) {
            int i = index + 1;
            int j = n - 1;
            int a = arr[index];
            while (i < j) {
                int b = arr[i];
                int c = arr[j];
                if ((a * a + b * b) == c * c) {
                    return true;
                }
                if (a + b <= c) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return false;
    }
}