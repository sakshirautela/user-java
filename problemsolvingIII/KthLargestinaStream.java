package problemsolvingIII;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestinaStream {
    static void main() {
        System.out.println(kthLargest(new int[]{3,2,1,3,3}, 2));
    }

    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
            int n = arr.length;
            ArrayList<Integer> list = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i <n;i++) {
                if(pq.size()<k){
                    pq.offer(arr[i]);
                }else if(arr[i]>pq.peek()){
                    pq.poll();
                    pq.offer(arr[i]);
                }

                if(pq.size()==k){
                    list.add(pq.peek());
                }else{
                    list.add(-1);
                }
            }
            System.out.println(pq);
            return list;
    }
}