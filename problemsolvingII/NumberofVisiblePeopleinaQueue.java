import java.util.Stack;

public class NumberofVisiblePeopleinaQueue {
    static void main() {
        int[] res = canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9});
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int[] max = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] <=heights[i]) {
                res[st.pop()]++;
            }
            if (!st.isEmpty()) {
                res[st.peek()]++;
            }
            st.push(i);
        }
        return res;
    }
}
