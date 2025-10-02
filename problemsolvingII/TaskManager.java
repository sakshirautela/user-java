import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskManager {
    HashMap<Integer, int[]> map = new HashMap<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] == a[0]) ? b[1] - a[1] : b[0] - a[0]);

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            int userid = task.get(0);
            int taksid = task.get(1);
            int priority = task.get(2);
            pq.add(new int[]{priority, taksid});
            map.put(taksid, new int[]{userid, priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new int[]{userId, priority});
        pq.add(new int[]{priority,taskId});
    }

    public void edit(int taskId, int newPriority) {
        map.put(taskId, new int[]{map.get(taskId)[0], newPriority});
        pq.add(new int[]{newPriority,taskId});

    }

    public void rmv(int taskId) {
        map.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty() && (!map.containsKey(pq.peek()[1]) || (map.containsKey(pq.peek()[1]) && pq.peek()[0] != map.get(pq.peek()[1])[1]))) {
            pq.remove();
        }
        if(pq.isEmpty()){
            return  -1;
        }
        int[] rmv=pq.remove();
        int userid=map.get(rmv[1])[0];
        map.remove(rmv[1]);
        return userid;
    }

    public static void main(String[] args) {

    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
/*class TaskManager {
    int[] priorities = new int[100001];
    int[] userIds = new int[100001];
    PriorityQueue<Long> PQ = new PriorityQueue<>((a, b) -> Long.compare(b, a));

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            priorities[taskId] = priority;
            userIds[taskId] = userId;
            PQ.offer((long) priority * 100001 + taskId);
        }
    }

    public void add(int userId, int taskId, int priority) {
        if (priorities[taskId] > 0)
            return;
        priorities[taskId] = priority;
        userIds[taskId] = userId;
        PQ.offer((long) priority * 100001 + taskId);
    }

    public void edit(int taskId, int newPriority) {
        priorities[taskId] = newPriority;
        PQ.offer((long) newPriority * 100001 + taskId);
    }

    public void rmv(int taskId) {
        priorities[taskId] = -1;
    }

    public int execTop() {
        while (!PQ.isEmpty()) {
            long current = PQ.poll();
            int taskId = (int) (current % 100001);
            int priority = (int) (current / 100001);
            if (priorities[taskId] != priority)
                continue;
            priorities[taskId] = -1;
            return userIds[taskId];
        }
        return -1;
    }
}

 */