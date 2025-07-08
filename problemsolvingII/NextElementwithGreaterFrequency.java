import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextElementwithGreaterFrequency {
    public static void main(String[] args) {
        System.out.println(findGreater(new int[] { 2, 1, 1, 3, 2, 1 }));
    }

    public static ArrayList<Integer> findGreater(int[] arr) {
        // code here
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && freq.get(arr[i]) > freq.get(arr[st.peek()])) {
                result[st.pop()] = arr[i];
            }
            st.push(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : result) {
            res.add(i);
        }
        return res;
    }
}