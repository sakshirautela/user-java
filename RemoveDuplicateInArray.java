import java.util.*;

public class RemoveDuplicateInArray {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i : arr) {
            hs.put(i,1);
        }
        for (int i = 0; i < arr.length; i++) {
            if(hs.containsKey(arr[i])){
                result.add(arr[i]);
                hs.remove(arr[i]);
            }
        }
        return result;
    }
}