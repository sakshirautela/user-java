import java.util.*;

public class DivideanArrayIntoSubarraysWithMinimumCostII {

    static void add(TreeMap<Integer,Integer> m,int x){
        m.put(x,m.getOrDefault(x,0)+1);
    }

    static void remove(TreeMap<Integer,Integer> m,int x){
        int c=m.get(x);
        if(c==1) m.remove(x);
        else m.put(x,c-1);
    }

    public static long minimumCost(int[] nums, int k, int dist) {

        int n = nums.length;

        TreeMap<Integer,Integer> include = new TreeMap<>();
        TreeMap<Integer,Integer> exclude = new TreeMap<>();

        long sum = nums[0];
        int size = 0;

        // initial window
        for(int i=1;i<=dist+1;i++){
            add(include,nums[i]);
            sum+=nums[i];
            size++;
        }

        // shrink to k-1
        while(size>k-1){
            int x=include.lastKey();
            remove(include,x);
            add(exclude,x);
            sum-=x;
            size--;
        }

        long res=sum;

        for(int i=1;i<n-1-dist;i++){

            int rem=nums[i];
            int addVal=nums[i+dist+1];

            // remove
            if(include.containsKey(rem)){
                remove(include,rem);
                sum-=rem;
                size--;

                // pull smallest from exclude
                if(!exclude.isEmpty()){
                    int x=exclude.firstKey();
                    remove(exclude,x);
                    add(include,x);
                    sum+=x;
                    size++;
                }
            }else{
                remove(exclude,rem);
            }

            // add
            if(size<k-1){
                add(include,addVal);
                sum+=addVal;
                size++;
            }
            else if(!include.isEmpty() && addVal < include.lastKey()){
                int x=include.lastKey();
                remove(include,x);
                add(exclude,x);
                sum-=x;

                add(include,addVal);
                sum+=addVal;
            }
            else{
                add(exclude,addVal);
            }

            res=Math.min(res,sum);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumCost(
                new int[]{25,13,22,14,42,14,34,12,25,15}, 3, 1));
    }
    public long minimumCostFast(int[] nums, int k, int dist) {
        int n = nums.length;
        PriorityQueue<Integer> pq_left = new PriorityQueue<>((a, b)->b-a);
        PriorityQueue<Integer> pq_right = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int valid_left = 0;
        long sum_left = 0;

        long res = Long.MAX_VALUE;

        for(int i=1; i<n; i++){
            if(i>=dist+2){
                int v = nums[i-dist-1];
                if(v<pq_left.peek()){
                    map.merge(v, 1, Integer::sum);
                    valid_left--;
                    sum_left -= v;
                }
                else if(v==pq_left.peek()){
                    pq_left.poll();
                    valid_left--;
                    sum_left -= v;
                }
                else if(v==pq_right.peek()){
                    pq_right.poll();
                }
                else{
                    map.merge(v, 1, Integer::sum);
                }
            }


            if(i<=k-1 || nums[i]<=pq_left.peek()){
                pq_left.offer(nums[i]);
                valid_left++;
                sum_left += nums[i];
            }
            else{
                pq_right.offer(nums[i]);
            }

            if(i>k-1){
                if(valid_left<k-1){
                    int v = pq_right.poll();
                    pq_left.offer(v);
                    valid_left++;
                    sum_left += v;
                }
                else if(valid_left>k-1){
                    int v = pq_left.poll();
                    valid_left--;
                    sum_left -= v;
                    pq_right.offer(v);
                }
            }


            while(!pq_left.isEmpty() && map.getOrDefault(pq_left.peek(), 0)>0){
                int v = pq_left.poll();
                map.merge(v, -1, Integer::sum);
            }
            while(!pq_right.isEmpty() && map.getOrDefault(pq_right.peek(), 0)>0){
                int v = pq_right.poll();
                map.merge(v, -1, Integer::sum);
            }

            if(i>=dist+1){
                res = Math.min(res, sum_left);
            }
        }
        return res+nums[0];
    }
}