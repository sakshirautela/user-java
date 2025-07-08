import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberofEventsThatCanBeAttended {
    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][] { {1,2},{2,3},{3,4},{1,2} }));
    }

    public static int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }

        return ans;
    }
    public int maxEventsFast(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        
        int[] root = new int[events[events.length - 1][1] + 2];
        
        for(int i=0;i<root.length;i++) 
            root[i]=i;
        
        int res=0;
        for(int[] e:events){
            int availableSlot=find(root,e[0]);
            
            if(availableSlot<=e[1]){
                res++;
                root[availableSlot]=find(root,availableSlot+1);
            }
            
        }
        return res;
    }
    
    public int find(int[] root,int i){
        if(root[i]!=i)
            return root[i]=find(root,root[i]);
        return i;
    }
}