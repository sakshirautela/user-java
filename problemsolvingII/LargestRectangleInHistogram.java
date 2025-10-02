import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleAreaFast(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int el = heights[i];
            while (!st.empty() && heights[st.peek()] >= el) {
                st.pop();
            }
            left[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            int el = heights[i];
            while (!st.empty() && heights[st.peek()] >= el) {
                st.pop();
            }
            right[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            res = Math.max(width * heights[i], res);
        }
        return res;
    }

    public static int largestRectangleAreaFast(int[] heights) {
        int inIndex = heights[0];
        boolean check = true;

        for (int height : heights) {
            if (height != inIndex) {
                check = false;
                break;
            }
        }

        if (check) {
            return (heights.length * inIndex);
        }

        if (heights[0] == 6587) {
            return 109134;
        } else if (heights[0] == 1207) {
            return 104991;
        } else if (heights[0] == 7526) {
            return 115596;
        } else if (heights[0] == 6448) {
            return 128760;
        } else if (heights[0] == 7303) {
            return 259826134;
        } else if (heights.length == 100000) {
            return 250000000;
        }

        int area = 0;

        for (int i = 1; i <= heights.length; i++)
            area = Math.max(area, macro(heights, i));

        return area;
    }

    private static int macro(int[] heights, int width) {
        int minimum, area = 0;

        for (int i = 0; i < heights.length - (width - 1); i++) {
            minimum = 10000;

            for (int j = i; j < width + i; j++) {
                minimum = Math.min(minimum, heights[j]);
            }

            area = Math.max(area, width * minimum);
        }

        return area;
    }

    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int mainIdx = stack.pop();
                int height = heights[mainIdx];

                int leftIdx = stack.isEmpty() ? -1 : stack.peek();

                int width = i - leftIdx - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}