
import java.util.*;

public class MaximumEmployeestoBeInvitedtoaMeeting {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int person = 0; person < n; ++person) {
            inDegree[favorite[person]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int person = 0; person < n; ++person) {
            if (inDegree[person] == 0) {
                q.offer(person);
            }
        }

        int[] depth = new int[n];
        Arrays.fill(depth, 1);

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            int nextNode = favorite[currentNode];
            depth[nextNode] = Math.max(depth[nextNode], depth[currentNode] + 1);
            if (--inDegree[nextNode] == 0) {
                q.offer(nextNode);
            }
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;
        for (int person = 0; person < n; ++person) {
            if (inDegree[person] == 0) continue; 

            int cycleLength = 0;
            int current = person;
            while (inDegree[current] != 0) {
                inDegree[current] = 0; 
                cycleLength++;
                current = favorite[current];
            }

            if (cycleLength == 2) {
                twoCycleInvitations += depth[person] + depth[favorite[person]];
            } else {
                longestCycle = Math.max(longestCycle, cycleLength);
            }
        }

        return Math.max(longestCycle, twoCycleInvitations);
    }
     public static int maximumInvitations2(int[]favorite){
        int n=favorite.length;
        int[]ins=new int[n];
        int[]queue=new int[n];
        int[]deep=new int[n];
        
        for (int i = 0; i < n; i++) {ins[favorite[i]]++;}

        int l=0,r=0;
        for (int i = 0; i < n; i++) {
            if(ins[i]==0) queue[r++]=i;
        }

        while (l<r){
            int cur=queue[l++];
            int next=favorite[cur];
            deep[next] = Math.max(deep[next], deep[cur] + 1);
            if (--ins[next] == 0) {
                queue[r++] = next;
            }
        }

        int smallCircle=0;
        int bigCircle=0;

        for (int i = 0; i < n; i++) {
            if(ins[i]!=0){
                ins[i]=0;
                int count=1;
                for(int j=favorite[i];j!=i;j=favorite[j]){
                    count++;
                    ins[j]=0;
                }

                if(count==2){
                    smallCircle+=deep[i]+deep[favorite[i]]+2;
                }else {
                    bigCircle=Math.max(bigCircle,count);
                }
            }
        }
        return Math.max(bigCircle,smallCircle);
    }
}
