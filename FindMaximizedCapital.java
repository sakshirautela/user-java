import java.util.PriorityQueue;
public class FindMaximizedCapital {
    static class Data implements Comparable<Data>{
        int profit;
        int capital;
        public Data(int i, int j) {
            this.capital=j;
            this.profit=i;
        }
        @Override
        public int compareTo(Data dt) {
            if(dt.capital>this.capital){
                return this.capital;
            }
            else if(dt.capital<this.capital){
                return dt.capital;
            }else{
                if(dt.profit<this.profit){
                    return this.profit;
                }else{
                    return dt.profit;
                }
            }
        }
        
    }
    public static  int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        PriorityQueue<Data> pq =new PriorityQueue();
        for (int i = 0; i < capitals.length; i++) {
            pq.add(new Data(profits[i],capitals[i]));
        }
        int n=0;
        int res=w;
        while (!pq.isEmpty()) {
            int p=pq.peek().profit;
            int c=pq.peek().capital;
            if(n<k && w>=pq.peek().capital){
                n++;
                res+=pq.peek().profit;
            }else if(pq.peek().capital==c && k<){

            }
        }
    }
    public static void main(String[] args[]){
        System.out.println(findMaximizedCapital());
    }
}