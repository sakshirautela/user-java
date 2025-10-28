import java.util.ArrayList;
import java.util.Arrays;

public class SortbyAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {1};
        rearrange(arr, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void rearrange(int[] arr, int x) {
        // code here
        ArrayList<Integer> array=new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            array.add(arr[i]);

        }

//      right-  Arrays.sort(array,(a,b) -> Integer.compare(Math.abs(x-a),Math.abs(x-b)));

        for(int i=0; i<arr.length; i++){
            arr[i] = array.get(i);

        }

    }

}

