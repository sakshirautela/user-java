import java.util.*;

public class KSizedSubarrayMaximumGFG {
    static class Data{
        int val;
        int idx;
        public Data(int val,int idx){
            this.val=val;this.idx=idx;
        }
    }
    public static ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        ArrayList<Integer> result=new ArrayList<Integer>();
        PriorityQueue<Data> pq=new PriorityQueue<Data>((a,b)->b.val-a.val);
        for(int i=0;i<k;i++){
            pq.add(new Data(arr[i],i));
        }
        result.add(pq.peek().val);
        for(int i=k;i<arr.length;i++){
            pq.add(new Data(arr[i],i));
            while(pq.peek().idx<=i-k){
                pq.remove();
            }
            result.add(pq.peek().val);
        }
        return result;
    }
    public static void main(String args[]){
        System.out.println(max_of_subarrays(4,new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}));
    }
}
