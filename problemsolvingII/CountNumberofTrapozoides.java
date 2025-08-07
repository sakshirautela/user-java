import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CountNumberofTrapozoides {
    public static void main(String[] args) {
        System.out.println();
    }

    static double mod = 10e9 + 7;

    public static int countTrapezoids(int[][] points) {

        int n = points.length, MOD = 1000000007;
        HashMap<Integer,Integer> freq=new HashMap<>();
        long res = 0, total = 0;
        for (int [] point:points) {
            freq.put(point[1],freq.getOrDefault(point[1],0)+1);
        }
         for(int count:freq.values()){
            long lines = count * (count - 1) / 2;
            res = (res + total * lines) % MOD;
            total = (total + lines) % MOD;
        }
        return (int)res;

    }

    private static int find(int l1, int l2) {
        int l1pais = 1;
        while (l1 > 2) {
            l1pais = (l1pais * l1);
            l1--;
        }
        int l2pair = 1;
        while (l2 > 2) {
            l2pair = (l2pair * l1);
            l2--;
        }
        return (int) ((l1pais * l2pair) % mod);
    }
}
