import java.util.*;

public class MinimumOperationsToSortString {
    static void main() {
        System.out.println(minOperations("edc"));
    }

    public static int minOperations(String s) {
        int n = s.length();
        char[] sorted = s.toCharArray();
        int sort = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sorted[i] > sorted[j]) {
                    char temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                    sort++;
                }
            }
        }
        return (sort==1 && n==2)?-1:sort;
    }
}