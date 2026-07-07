package problemsolvingIII;

import java.util.*;

public class JumpGameIV {
    static void main() {
        System.out.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new java.util.LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        q.add(new int[]{0, 0});
        visited[0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int idx = curr[0];
            int steps = curr[1];
            if (idx == n - 1) return steps;
            if (map.containsKey(arr[idx])) {
                for (int next : map.get(arr[idx])) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(new int[]{next, steps + 1});
                    }
                }
                map.remove(arr[idx]);
            }
            int left = idx - 1;
            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                q.add(new int[]{left, steps + 1});
            }

            int right = idx + 1;
            if (right < n && !visited[right]) {
                visited[right] = true;
                q.add(new int[]{right, steps + 1});
            }
        }
        return -1;
    }

    public int minJumpsFast(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(n - 1);
        vis[n - 1] = true;
        int count = 0, x;

        while (!q.isEmpty()) {
            int sz = q.size();
            count++;
            for (int k = 0; k < sz; k++) {
                int ind = q.poll();

                x = ind - 1;
                if (x == 0) return count;
                if (x >= 0 && x < n && !vis[x]) {
                    vis[x] = true;
                    q.add(x);
                }

                x = ind + 1;
                if (x == 0) return count;
                if (x >= 0 && x < n && !vis[x]) {
                    vis[x] = true;
                    q.add(x);
                }

                List<Integer> list = map.get(arr[ind]);
                if (list != null) {
                    for (int i : list) {
                        if (!vis[i]) {
                            if (i == 0) return count;
                            vis[i] = true;
                            q.add(i);
                        }
                    }
                }
                map.remove(arr[ind]);
            }
        }
        return -1;
    }

}
