public class FindMinimumLogTransportationCost {
    public long minCuttingCost(int n, int m, int k) {
        long sum = 0;
        if(n > k){
            sum = k;
        }
        if(m >  k){
            sum = k;
        }
        while(n > k){
            n = n - k;  
            sum *= n;
        }
        while(m > k){
            m = m-k;
         sum *= m;
        }
        return sum;
    }
}