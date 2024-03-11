import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

class MergeInterval {
    public static int[][] merge2(int[][] inter) {
        Arrays.sort(inter,(a,b)->a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{inter[0][0],inter[0][1]});
        for (int i = 1; i < inter.length; i++) {
            if(result.get(result.size()-1)[1]>=inter[i][0]){
                int end = Math.max(result.get(result.size()-1)[1],inter[i][1]);                
                int start = Math.min(result.get(result.size()-1)[0],inter[i][0]);
                result.remove(result.size()-1);
                result.add(new int[]{start,end});
            }
            else{
                result.add(new int[]{inter[i][0],inter[i][1]});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static int[][] merge(int[][] inter) {
        Arrays.sort(inter,(a,b) -> a[0]-b[0]);
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < inter.length; i++) {
            int a2 = inter[i][0];
            int b2 = inter[i][1];
            if (!st.isEmpty() && a2 <= st.peek()[1] && st.peek()[0] <= a2  && st.peek()[1] >= b2){
                int[] temp = st.pop();
                st.push(new int[]{temp[0], temp[1]});
            }else if (!st.isEmpty() && a2 == st.peek()[1] && st.peek()[0] <= st.peek()[1]  && st.peek()[1] <= b2){
                int[] temp = st.pop();
                st.push(new int[]{temp[0], b2});
            } else if (!st.isEmpty() && a2 >= st.peek()[0] && st.peek()[1] > a2  && st.peek()[1] <= b2){
                int[] temp = st.pop();
                st.push(new int[]{temp[0], b2});
            }else if (!st.isEmpty() && a2 > st.peek()[1] && st.peek()[0] <= st.peek()[1] && st.peek()[1] < b2 ){
                st.push(new int[]{a2, b2});
            } else if (!st.isEmpty() && st.peek()[0] < st.peek()[1] && a2 > st.peek()[1]) {
                st.push(new int[]{a2, b2});
            } else if (st.isEmpty()) {
                st.push(new int[]{a2, b2});
            }

        }
        int res[][] = new int[st.size()][2];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            int[] temp = st.pop();
            res[i][0] = temp[0];
            res[i][1] = temp[1];
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 2,3 }, {3,9},{5,7},{4,10},{9,10} };
        int res1[][] = merge2(intervals);
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i][0] + "," + res1[i][1]+" ");
        }
        System.out.println();
    }
}
class Solutiona {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
			return intervals;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return Integer.compare(a[0],b[0]);
            }
        });

        List<int[]> ans = new ArrayList();
        int[] temp = intervals[0];
        ans.add(temp);
        
        for(int i =1; i<intervals.length;i++){
            
            if(temp[1]>=intervals[i][0]){
                temp[1] = Math.max(intervals[i][1],temp[1]);
            }
            else{
                temp = intervals[i];
                ans.add(temp);
            }
        }

            return ans.toArray(new int [ans.size()][]);

        }

    }
class Solution2 {
    public int[][] merge(int[][] intervals) {
        
        Queue<int [] > q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int [] interval:intervals){
            q.add(interval);
        }
        
        List<int []> result = new ArrayList<>();
        int [] current = q.remove();
        result.add(current);
        
        while(!q.isEmpty()){
            
            int endCurrent = current[1];
            int [] next = q.remove();
            int startNext = next[0];
            int endNext = next[1];
            
            if(endCurrent>=startNext){
                current[1]=Math.max(endCurrent,endNext);
            }else {
                current = next;
                result.add(current);
            }
            
        }
        return result.toArray(new int [result.size()][]);
    }
}