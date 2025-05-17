import java.util.ArrayList;
import java.util.PriorityQueue;

public class SmallestRangeInKList {
    public static void main(String[] args) {
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        // code here
        int n = arr[0].length;
        int k = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        ArrayList<Integer> al = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            maxVal = Math.max(maxVal, arr[i][0]);
            pq.add(new int[]{arr[i][0],i,0});
        }
        int range=Integer.MAX_VALUE,min=-1,max=-1;
        while (true) {
            int[] curr=pq.poll();
            int minVal=curr[0];
            if(maxVal-minVal<range){
                range=maxVal-minVal;
                min=minVal;
                max=maxVal;
            }
            if(curr[2]+1==n){
                break;
            }
            int nextVal=arr[curr[1]][curr[2]+1];
            maxVal=Math.max(maxVal,nextVal);
            pq.add(new int[]{nextVal,curr[1],curr[2]+1});
        }
        al.add(min);
        al.add(max);
        return al;
    }
}