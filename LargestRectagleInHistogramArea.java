import java.util.Stack;

public class LargestRectagleInHistogramArea {
    public static int largestRectangleArea(int[] heights) {
        int area = heights[0];
        Stack<Integer> st = new Stack();
        for (int i = 0; i < heights.length; i++) {
            int cont = 1;
            while (!st.isEmpty() && st.peek() <= heights[i]) {
                cont++;
                area = Math.max(st.peek() * cont, area);
                st.pop();
            }
            area = Math.max(area, heights[i]);
            st.push(heights[i]);

        }
        return area;
    }

    public static void main(String args[]) {
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    }
}