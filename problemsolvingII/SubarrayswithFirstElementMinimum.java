import java.util.Stack;

public class SubarrayswithFirstElementMinimum {
    static void main() {
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2}));
    }

    public static int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for (int l = n - 1; l >= 0; l--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[l]) {
                st.pop();
            }
            int r = (st.isEmpty()) ? n : st.peek();
            res+=r-l;
            st.push(l);
        }
        return res;
    }

}
