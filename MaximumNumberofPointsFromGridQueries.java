package com.learn.java.problemsolving;

import java.util.*;

public class MaximumNumberofPointsFromGridQueries {
    public static void main(String[] args) {
        int[] res = maxPoints(new int[][] { {} }, new int[] {});
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int n = queries.length;
        int[] result = new int[n];
        int[][] visited = new int[rows][cols];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<int[]> sortedQueries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sortedQueries.add(new int[] { queries[i], i });
        }
        sortedQueries.sort(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = 1;
        int points = 0;

        for (int[] q : sortedQueries) {
            int queryVal = q[0], queryIdx = q[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryVal) {
                int[] top = minHeap.poll();
                int row = top[1], col = top[2];
                points++;

                for (int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0) {
                        minHeap.offer(new int[] { grid[nr][nc], nr, nc });
                        visited[nr][nc] = 1;
                    }
                }
            }
            result[queryIdx] = points;
        }
        return result;
    }

    public int[] maxPoints2(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length, k = queries.length;
        var qs = new HashMap<Integer, ArrayDeque<int[]>>();
        var result = new HashMap<Integer, Integer>();
        var sorted = Arrays.copyOf(queries, k);
        var visited = new boolean[m][n];
        Arrays.sort(sorted);
        for (int i = 0; i < k; i++)
            qs.putIfAbsent(sorted[i], new ArrayDeque<>());
        for (int i = 0, acc = 0; i < k; i++) {
            var e = sorted[i];
            var res = 0;
            if (!result.containsKey(e)) {
                if (grid[0][0] >= e)
                    result.put(e, 0);
                else {
                    var q = qs.get(e);
                    if (!visited[0][0]) {
                        q.add(new int[] { 0, 0 });
                        visited[0][0] = true;
                    }
                    while (!q.isEmpty()) {
                        var el = q.removeFirst();
                        res++;
                        int x = el[0], y = el[1];
                        if (x > 0 && !visited[x - 1][y]) {
                            if (grid[x - 1][y] < e)
                                q.addLast(new int[] { x - 1, y });
                            else {
                                var nxt = Arrays.binarySearch(sorted, grid[x - 1][y] + 1);
                                if (nxt < 0)
                                    nxt = -nxt - 1;
                                if (nxt > 0 && nxt < k)
                                    qs.get(sorted[nxt]).addLast(new int[] { x - 1, y });
                            }
                            visited[x - 1][y] = true;
                        }
                        if (x < m - 1 && !visited[x + 1][y]) {
                            if (grid[x + 1][y] < e)
                                q.addLast(new int[] { x + 1, y });
                            else {
                                var nxt = Arrays.binarySearch(sorted, grid[x + 1][y] + 1);
                                if (nxt < 0)
                                    nxt = -nxt - 1;
                                if (nxt > 0 && nxt < k)
                                    qs.get(sorted[nxt]).addLast(new int[] { x + 1, y });
                            }
                            visited[x + 1][y] = true;
                        }
                        if (y > 0 && !visited[x][y - 1]) {
                            if (grid[x][y - 1] < e)
                                q.addLast(new int[] { x, y - 1 });
                            else {
                                var nxt = Arrays.binarySearch(sorted, grid[x][y - 1] + 1);
                                if (nxt < 0)
                                    nxt = -nxt - 1;
                                if (nxt > 0 && nxt < k)
                                    qs.get(sorted[nxt]).addLast(new int[] { x, y - 1 });
                            }
                            visited[x][y - 1] = true;
                        }
                        if (y < n - 1 && !visited[x][y + 1]) {
                            if (grid[x][y + 1] < e)
                                q.addLast(new int[] { x, y + 1 });
                            else {
                                var nxt = Arrays.binarySearch(sorted, grid[x][y + 1] + 1);
                                if (nxt < 0)
                                    nxt = -nxt - 1;
                                if (nxt > 0 && nxt < k)
                                    qs.get(sorted[nxt]).addLast(new int[] { x, y + 1 });
                            }
                            visited[x][y + 1] = true;
                        }
                    }
                    acc += res;
                    result.put(e, acc);
                }
            }
        }
        var answer = new int[k];
        for (int i = 0; i < k; i++)
            answer[i] = result.get(queries[i]);
        return answer;
    }
}