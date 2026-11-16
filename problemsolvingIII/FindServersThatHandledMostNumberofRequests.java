package problemsolvingIII;

import java.util.*;

public class FindServersThatHandledMostNumberofRequests {
    static void main() {
        System.out.println(busiestServers(3,new int[]{},new int[]{}));
    }
    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n=arrival.length;
        PriorityQueue<Integer> server=new PriorityQueue<>();
        PriorityQueue<int[]>busy=new PriorityQueue<>((a, b) -> a[0] - b[0]); // 0=time and 1=index of server
        for(int i=0;i< k;i++){
            server.add(k+1);
        }
        int[][] times=new int[n][2];
        for (int i=0;i<n;i++){
            times[i][0]=arrival[i];
            times[i][1]=arrival[i]+load[i];
        }
        List<Integer> ans=new ArrayList<>();
        int max=0;
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<n;i++){
            int time=times[i][0];
            freeUpServers(time,busy,times);
            if(server.isEmpty()){
                assert busy.peek() != null;
                time=busy.peek()[0];
                freeUpServers(time,server,busy,servers);
            }
            int[] s=server.poll();
            ans[i]=s[1];
            busy.offer(new int[]{time+tasks[i],s[1]});
        }
        return ans;
    }
    private static void freeUpServers(int time, PriorityQueue<int[]> server, PriorityQueue<int[]> busy, int[] servers) {
        while (!busy.isEmpty() && busy.peek()[0]<=time){
            int[] t=busy.poll();
            int i=t[1];
            server.offer(new int[]{servers[i],i});
        }
    }
}

package problemsolvingIII;

import java.util.*;

public class FindServersThatHandledMostNumberofRequests {

    public static List<Integer> busiestServers(
            int k, int[] arrival, int[] load) {
        int n = arrival.length;
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] completed = busy.poll();
                available.add(completed[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            int server = i % k;
            Integer s = available.ceiling(server);
            if (s == null) {
                s = available.first();
            }
            available.remove(s);
            count[s]++;
            busy.offer(new int[]{
                    time + load[i], s
            });
        }
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(
                busiestServers(
                        3,
                        new int[]{1, 2, 3, 4, 5, 6},
                        new int[]{5, 2, 3, 3, 3, 2}
                )
        );
    }
}
