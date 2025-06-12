import java.util.PriorityQueue;

public class KClosestElements {
    public static void main(String[] args) {
        int[] res = printKClosest(new int[] {1, 3, 4, 10, 12}, 2, 4);
        for (int i : res) {
            System.out.println(i);
        }
    }

    static int[] printKClosest(int[] arr, int k, int x) {
        // code here
        int n = arr.length;
        int[] res = new int[k];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(x - arr[i]);
            if(diff==0){
                continue;
            }else{
                pq.offer(new int[]{diff,arr[i]});
            }
        }
        int idx=0;
        while (!pq.isEmpty() && idx<k) {
            res[idx++]=pq.remove()[1];
        }
        return res;
    }
}