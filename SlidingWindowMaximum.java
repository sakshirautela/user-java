import java.util.PriorityQueue;
public class SlidingWindowMaximum {
    static class pairs implements Comparable<pairs> {
        int idx;
        int val;

        pairs(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(pairs p) {
            //assending
            //return this.val-p.val;
            //descending
            return p.val - this.val;
        }
    }

     public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        int k=3;
        PriorityQueue<pairs> pq = new PriorityQueue<>();
        int res[] = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(new pairs(nums[i], i));
        }
        res[0] = pq.peek().val;
        for (int i = k; i < nums.length; i++) {
            while (pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new pairs(nums[i], i));
            res[i - k + 1] = pq.peek().val; //<0?pq.peek().val:0;
        }
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}

