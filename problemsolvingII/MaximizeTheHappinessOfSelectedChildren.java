import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeTheHappinessOfSelectedChildren {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1,2,3},2));
    }
    public static long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:happiness){
            pq.add(i);
        }
        System.out.println(pq);
        int count=0;
        int happy=0;
        while (!pq.isEmpty()&&k>0){
            int a=pq.remove();
            if(a-count>0){
                happy+=a-count;
            }else{
                return happy;
            }
            count++;
            k--;
        }
        return happy;
    }
    public long maximumHappinessSumFast(int[] happiness, int k) {
        long happy = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        int count = 0;
        for (int i = n - 1; i >= 0 && k-- > 0; i--) {
            int val = happiness[i] - count;
            if (val <= 0) break;
            happy += val;
            count++;
        }
        return happy;
    }
}