import java.util.*;

public class MinimumCosttoConvertStringII {
    static void main() {
        System.out.println(minimumCost("", "", new String[]{}, new String[]{}, new int[]{}));
    }

    static class Edge {
        int cost;
        String dest;
        Edge(int cost, String dest) {
            this.cost = cost;
            this.dest = dest;
        }
    }

    public static long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = original.length;
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            graph.computeIfAbsent(original[i], k -> new ArrayList<>()).add(new Edge(cost[i], changed[i]));
        }
        Set<String> nodes = new HashSet<>();
        nodes.addAll(Arrays.asList(original));
        nodes.addAll(Arrays.asList(changed));
        Map<String, Map<String, Long>> dist = new HashMap<>();
        for (String s : nodes) {
            dist.put(s, dijkstra(s, graph));
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE) continue;

            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (String o : nodes) {
                int len = o.length();
                if (i + len > n) continue;

                if (source.substring(i, i + len).equals(o)) {
                    for (String c : nodes) {
                        if (target.substring(i, i + len).equals(c)) {
                            Long d = dist.get(o).get(c);
                            if (d != null) {
                                dp[i + len] = Math.min(dp[i + len], dp[i] + d);
                            }
                        }
                    }
                }
            }
        }

        return dp[n] == Long.MAX_VALUE ? -1 : dp[n];
    }

    private static Map<String, Long> dijkstra(String start, Map<String, List<Edge>> graph) {
        Map<String, Long> dist = new HashMap<>();
        PriorityQueue<Map.Entry<String, Long>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        dist.put(start, 0L);
        pq.offer(Map.entry(start, 0L));

        while (!pq.isEmpty()) {
            var cur = pq.poll();
            String u = cur.getKey();
            long d = cur.getValue();

            if (d > dist.get(u)) continue;

            for (Edge e : graph.getOrDefault(u, List.of())) {
                long nd = d + e.cost;
                if (nd < dist.getOrDefault(e.dest, Long.MAX_VALUE)) {
                    dist.put(e.dest, nd);
                    pq.offer(Map.entry(e.dest, nd));
                }
            }
        }
        return dist;
    }

}