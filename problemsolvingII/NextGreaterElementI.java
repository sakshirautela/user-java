import java.util.Stack;

public class NextGreaterElementI {
    static void main() {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums1.length;
        int[] max = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[st.peek()] <=nums1[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                max[i]=nums2[st.peek()];
            }
            st.push(i);
        }
        return max;
    }
}