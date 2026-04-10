import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class IntersectionofTwoSortedArrays {
    static void main() {
        System.out.println(intersection(new int[]{}, new int[]{1}));
    }

    static ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i:a){
            set.add(i);
        }
        for(int i:b){
            if(set.contains(i)){
                set2.add(i);
            }
        }
        ArrayList<Integer> al= new ArrayList<>(set2);
        Collections.sort(al);
        return al;
    }
}
