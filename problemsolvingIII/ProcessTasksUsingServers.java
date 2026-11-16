package problemsolvingIII;

import java.util.PriorityQueue;

public class ProcessTasksUsingServers {
    static void main() {
        int[] res = assignTasks(new int[]{}, new int[]{});
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] assignTasks(int[] servers, int[] tasks) {
        int n = tasks.length;
        PriorityQueue<int[]> server = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int[] ans = new int[n];
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]); // 0=time and 1=index of server
        int time = 0;
        for (int i = 0; i < servers.length; i++) {
            server.add(new int[]{servers[i], i});
        }
        for (int i = 0; i < n; i++) {
            time = Math.max(time, i);
            freeUpServers(time, server, busy, servers);
            if (server.isEmpty()) {
                assert busy.peek() != null;
                time = busy.peek()[0];
                freeUpServers(time, server, busy, servers);
            }
            int[] s = server.poll();
            ans[i] = s[1];
            busy.offer(new int[]{time + tasks[i], s[1]});
        }
        return ans;
    }

    private static void freeUpServers(int time, PriorityQueue<int[]> server, PriorityQueue<int[]> busy, int[] servers) {
        while (!busy.isEmpty() && busy.peek()[0] <= time) {
            int[] t = busy.poll();
            int i = t[1];
            server.offer(new int[]{servers[i], i});
        }
    }
}
