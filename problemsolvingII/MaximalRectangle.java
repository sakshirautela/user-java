import java.util.Arrays;
import java.util.Stack;


class Solution {
    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
        System.out.println(maximalRectangle2(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        int[] height = new int[m];
        int res=0;
        for (char[] chars : matrix) {
            for (int j = 0; j < m; j++) {
                if (chars[j] == '1') {
                    height[j] += 1;
                }
            }
            res = Math.max(res, largestArea(height));
        }
        return res;
    }

    private static int largestArea(int[] heights) {
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
    public static  int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix[0].length;

        int[] heights = new int[n];
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];
        Arrays.fill(rightBoundaries, n);

        int maxRectangle = 0;

        for (char[] chars : matrix) {
            int left = 0;

            updateHeightsAndLeftBoundaries(chars, heights, leftBoundaries, left);

            updateRightBoundaries(chars, rightBoundaries, n);

            maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);
        }

        return maxRectangle;
    }

    private static void updateHeightsAndLeftBoundaries(char[] row, int[] heights, int[] leftBoundaries, int left) {
        for (int j = 0; j < heights.length; j++) {
            if (row[j] == '1') {
                heights[j]++;
                leftBoundaries[j] = Math.max(leftBoundaries[j], left);
            } else {
                heights[j] = 0;
                leftBoundaries[j] = 0;
                left = j + 1;
            }
        }
    }

    private static void updateRightBoundaries(char[] row, int[] rightBoundaries, int right) {
        for (int j = rightBoundaries.length - 1; j >= 0; j--) {
            if (row[j] == '1') {
                rightBoundaries[j] = Math.min(rightBoundaries[j], right);
            } else {
                rightBoundaries[j] = right;
                right = j;
            }
        }
    }

    private static int calculateMaxRectangle(int[] heights, int[] leftBoundaries, int[] rightBoundaries, int maxRectangle) {
        for (int j = 0; j < heights.length; j++) {
            int width = rightBoundaries[j] - leftBoundaries[j];
            int area = heights[j] * width;
            maxRectangle = Math.max(maxRectangle, area);
        }
        return maxRectangle;
    }
}