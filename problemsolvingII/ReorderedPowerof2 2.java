import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ReorderedPowerof2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(10));
    }

    public static boolean reorderedPowerOf2(int n) {
        List<Integer> al = new ArrayList<>();
        int size=0;
        while (n > 0) {
            al.add(n % 10);
            n /= 10;
            size++;
        }
        HashSet<List<Integer>> set = new HashSet<>();
        getPermutation(al, 0, size, set);
        for (List<Integer> s:set) {
            List<Integer> li=s;
            int num=0;
            if(li.get(0)==0){
                continue;
            }
            System.out.println(li);
            for (int i = 0; i <size ; i++) {
                num=(num*10)+li.get(i);
            }
            if((num & (num-1))==0){
                System.out.println((num&(num-1)));
                return  true;
            }
        }
        return false;
    }

    private static void getPermutation(List<Integer> al, int i, int n, HashSet<List<Integer>> set) {
        if (i == n) {
            set.add(new ArrayList<>(al));
            return;
        }
        for (int j = i; j < n; j++) {
            Collections.swap(al, i, j);
            getPermutation(al, i + 1, n, set);
            Collections.swap(al, j, i);
        }
    }
    public boolean reorderedPowerOf2Fast(int n) {
        int count = counter(n);

        for (int i = 0; i < 30; ++i)
            if (counter(1 << i) == count)
                return true;

        return false;
    }

    private int counter(int n) {
        int count = 0;

        for (; n > 0; n /= 10)
            count += Math.pow(10, n % 10);

        return count;
    }
}
