import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnitConversionI {
    @SuppressWarnings("unused")
    public int[] baseUnitConversions(int[][] conversions) {
        final int MOD = 1_000_000_007;
        int maxUnit = 0;
        for (int[] conv : conversions) {
            maxUnit = Math.max(maxUnit, Math.max(conv[0], conv[1]));
        }
        int n = maxUnit + 1;
        int[] baseUnitConversion = new int[n];
        Arrays.fill(baseUnitConversion, 0); // Initialize all to 0
        baseUnitConversion[0] = 1; // Base unit is 1

        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] conv : conversions) {
            int source = conv[0];
            int target = conv[1];
            int factor = conv[2];
            graph.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[] { target, factor });
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!graph.containsKey(current)) {
                continue;
            }
            for (int[] edge : graph.get(current)) {
                int target = edge[0];
                int factor = edge[1];
                if (baseUnitConversion[target] == 0) {
                    baseUnitConversion[target] = (int) ((long) baseUnitConversion[current] * factor % MOD);
                    queue.offer(target);
                }
            }
        }

        return baseUnitConversion;
    }
}
