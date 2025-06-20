import java.util.Stack;

public class RemoveTheBalls {
    public static void main(String[] args) {
        System.out.println(findLength(new int[] {}, new int[] {}));
    }

    public static int findLength(int[] color, int[] radius) {
        // code here
        Stack<int[]> st = new Stack<>();
        int n = color.length;
        for (int i = 0; i < n; i++) {
            int curr[] = { color[i], radius[i] };
            if (!st.isEmpty() && st.peek()[1] == curr[1] && st.peek()[0] == curr[0]) {
                st.pop();
            } else {
                st.push(curr);
            }
        }
        return st.size();
    }
}