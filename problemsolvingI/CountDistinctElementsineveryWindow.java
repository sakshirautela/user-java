
import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsineveryWindow {
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
    }

    static ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }
        al.add(freq.size());
        for (int i = k; i < arr.length; i++) {
            freq.put(arr[i-k],freq.getOrDefault(arr[i-k],0)-1);
            if(freq.get(arr[i-k])<=0){
                freq.remove(arr[i-k]);
            }
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
            al.add(freq.size());

        }
        return al;
    }
}
