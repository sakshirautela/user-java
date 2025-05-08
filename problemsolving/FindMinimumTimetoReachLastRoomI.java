import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinimumTimetoReachLastRoomI {
    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][] { { 0, 4 }, { 4, 4 } }));
    }
    // class Solution {
    // public int minTimeToReach(int[][] moveTime) {
    // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]- b[2]);

    // pq.add(new int[]{0, 0, 0});
    // Set<String> visited = new HashSet<>();
    // visited.add("0 0");

    // int n = moveTime.length;
    // int m = moveTime[0].length;
    // int[] dx = {1, -1, 0, 0};
    // int[] dy = {0, 0, 1, -1};
    // while(!pq.isEmpty()) {
    // int[] current = pq.poll();

    // if (current[0] == (n - 1) && current[1] == (m-1)) {
    // return current[2];
    // }

    // for(int i=0;i<4;i++) {
    // int x = current[0] + dx[i];
    // int y = current[1] + dy[i];

    // String xy = x + " " + y;
    // if (valid(x, y, n, m) && !visited.contains(xy)) {
    // int waitTime = Math.max(moveTime[x][y] - current[2], 0);

    // pq.add(new int[]{x, y, waitTime + current[2] + 1});
    // visited.add(xy);
    // }
    // }
    // }

    // return -1;
    // }

    // private boolean valid(int x, int y, int n, int m) {
    // return x >= 0 && x < n && y >= 0 && y < m;
    // }
    // }

    private static class Room implements Comparable<Room> {
        final int openTime;
        Room[] adjacent;
        Room next;

        Room() {
            openTime = Integer.MAX_VALUE;
        }

        Room(int openTime) {
            this.openTime = openTime;
            next = this; // indicates that this Room hasn't been approached yet
        }

        @Override
        public int compareTo(Room other) {
            return openTime - other.openTime;
        }
    }

    private static final Room DUMMY_ROOM = new Room();

    private static Room initRooms(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        Room[][] rooms = new Room[n][m];
        for (int i = 0; i < n; i++) {
            int[] mtRow = moveTime[i];
            Room[] rRow = rooms[i];
            for (int j = 0; j < m; j++)
                rRow[j] = new Room(mtRow[j]);
        }
        Room[] dummyRow = new Room[m];
        Arrays.fill(dummyRow, DUMMY_ROOM);
        Room[] prevRow = dummyRow;
        Room[] curRow = rooms[0];
        n--;
        m--;
        for (int i = 0; i <= n; i++) {
            Room[] nextRow = i < n ? rooms[i + 1] : dummyRow;
            Room prev = DUMMY_ROOM;
            Room cur = curRow[0];
            for (int j = 0; j <= m; j++) {
                Room next = j < m ? curRow[j + 1] : DUMMY_ROOM;
                cur.adjacent = new Room[] { prev, prevRow[j], next, nextRow[j] };
                prev = cur;
                cur = next;
            }
            prevRow = curRow;
            curRow = nextRow;
        }
        Room start = rooms[0][0];
        start.next = rooms[n][m]; // finish
        return start;
    }

    public static int minTimeToReach(int[][] moveTime) {
        Room start = initRooms(moveTime);
        Room finish = start.next;
        Queue<Room> waitingToEnter = new PriorityQueue<>();
        waitingToEnter.add(DUMMY_ROOM); // guard Room to prevent NPE
        start.next = null;
        Room exitingHead = start;
        int currentTime = 0;
        while (true) {
            Room exitingHeadNew = null;
            while (exitingHead != null) {
                for (Room adj : exitingHead.adjacent)
                    if (adj.next == adj) {
                        if (adj == finish)
                            return Math.max(currentTime, finish.openTime) + 1;
                        if (adj.openTime <= currentTime) {
                            adj.next = exitingHeadNew;
                            exitingHeadNew = adj;
                        } else {
                            adj.next = null;
                            waitingToEnter.offer(adj);
                        }
                    }
                exitingHead = exitingHead.next;
            }
            exitingHead = exitingHeadNew;
            int queueTime;
            while ((queueTime = waitingToEnter.peek().openTime) <= currentTime) {
                Room entering = waitingToEnter.poll();
                entering.next = exitingHead;
                exitingHead = entering;
            }
            if (++currentTime < queueTime && exitingHead == null)
                currentTime = queueTime;
        }
    }
    class Tuple implements Comparable<Tuple>{
        int row;
        int col;
        int time;
    
        Tuple(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
        
        public int compareTo(Tuple t2) {
            return this.time - t2.time;
        }
    }
    
        public int minTimeToReach3(int[][] moveTime) {
            int n = moveTime.length;
            int m = moveTime[0].length;
        
            int dis[][] = new int[n][m];
    
            for(int i=0; i<n; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE);
            }
    
            dis[0][0] = 0;
    
            PriorityQueue<Tuple> pq = new PriorityQueue<>();
            pq.add(new Tuple(0, 0, 0));
    
    
            int drow[] = {-1, 0, 1, 0};
            int dcol[] = {0, 1, 0, -1};
            while(!pq.isEmpty()) {
                Tuple t = pq.remove();
                int row = t.row;
                int col = t.col;
                int time = t.time;
    
                if(row == n-1 && col == m-1) {
                    return time;
                }
                for(int i=0; i<4; i++) {
                    int nrow = row + drow[i];
                    int ncol = col + dcol[i];
    
                    if(nrow >= 0 && nrow < n && ncol < m && ncol >= 0) {
                        int newTime = Math.max(time, moveTime[nrow][ncol]) + 1;
    
                        if(newTime < dis[nrow][ncol]) {
                            dis[nrow][ncol] = newTime;
    
                            pq.add(new Tuple(nrow, ncol, newTime));
                        }
                    }   
                }
            }
    
            return dis[n-1][m-1];
        }
    public static int minTimeToReachWrong(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + moveTime[i][0] + 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + moveTime[0][i] + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + moveTime[i][j] + 1;
            }
        }
        print(dp);
        return dp[m - 1][n - 1] - moveTime[m - 1][n - 1];
    }

    private static void print(int[][] dp) {
        for (int[] is : dp) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}