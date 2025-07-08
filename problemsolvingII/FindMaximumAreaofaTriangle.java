import java.util.HashMap;

import java.util.Map;

public class FindMaximumAreaofaTriangle {
    public long maxArea(int[][] coords) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (int[] point : coords) {
            int x = point[0], y = point[1];
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        Map<Integer, int[]> verticalLineMap = new HashMap<>();
        Map<Integer, int[]> horizontalLineMap = new HashMap<>();

        for (int[] point : coords) {
            int x = point[0], y = point[1];

            verticalLineMap.putIfAbsent(x, new int[]{y, y});
            int[] yRange = verticalLineMap.get(x);
            yRange[0] = Math.min(yRange[0], y);
            yRange[1] = Math.max(yRange[1], y);

            horizontalLineMap.putIfAbsent(y, new int[]{x, x});
            int[] xRange = horizontalLineMap.get(y);
            xRange[0] = Math.min(xRange[0], x);
            xRange[1] = Math.max(xRange[1], x);
        }

        long maxDoubleArea = 0;

        for (Map.Entry<Integer, int[]> entry : verticalLineMap.entrySet()) {
            int x = entry.getKey();
            int yMin = entry.getValue()[0], yMax = entry.getValue()[1];
            if (yMax > yMin) {
                long base = (long)(yMax - yMin);
                maxDoubleArea = Math.max(maxDoubleArea, base * (maxX - x));
                maxDoubleArea = Math.max(maxDoubleArea, base * (x - minX));
            }
        }

        for (Map.Entry<Integer, int[]> entry : horizontalLineMap.entrySet()) {
            int y = entry.getKey();
            int xMin = entry.getValue()[0], xMax = entry.getValue()[1];
            if (xMax > xMin) {
                long base = (long)(xMax - xMin);
                maxDoubleArea = Math.max(maxDoubleArea, base * (maxY - y));
                maxDoubleArea = Math.max(maxDoubleArea, base * (y - minY));
            }
        }

        return maxDoubleArea > 0 ? maxDoubleArea : -1;
    }
}