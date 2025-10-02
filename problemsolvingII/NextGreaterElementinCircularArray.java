import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementinCircularArray {
    public static void main(String[] args) {
        System.out.println(nextGreater(new int[]{1, 3, 2, 4}));
    }

    public static ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n-1;i>=0;i--) {
            st.push(arr[i]);
        }
        for (int i = n-2;i>=0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                al.add(-1);
            }else{
                al.add(st.peek());
            }
            st.push(arr[i]);
        }
        return al;
    }
}
