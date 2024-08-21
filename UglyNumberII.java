import java.util.*;

public class UglyNumberII {
    public static boolean isUgly(int n,ArrayList<Boolean> dp) {
        if(dp.get(n)){
            return dp.get(n);
        }
        if(n>0 && n<=3){
            dp.add(n,true);
            return dp.get(n);
        }
        if(n%2==0){
             dp.add(n/2,isUgly(n/2, dp));
             return dp.get(n/2);
        }
        if(n%3==0){
            dp.add(n/3,isUgly(n/3, dp));
             return dp.get(n/3);
        }
        if(n%5==0){
            dp.add(n/5,isUgly(n/5, dp));
             return dp.get(n/5);
        }
        dp.add(n,false);
        return dp.get(n);
    }
    public static int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashSet<Integer> hs=new HashSet<Integer>();
        pq.add(1);
        int current=1;
        for(int i=0;i<n;i++){
            current=pq.remove();
            if(!hs.contains(current*2)){
                pq.add(current*2);
                hs.add(current*2);
            }   
            if(!hs.contains(current*3)){
                pq.add(current*3);
                hs.add(current*3);
            }
            if(!hs.contains(current*5)){
                pq.add(current*5);
                hs.add(current*5);
            }
        }
        return current;
    }
    public static int nthUglyNumberDP(int n) {
        int[] dp=new int[n];
        int idx2=0,idx3=0,idx5=0;
        int n2=0,n3=0,n5=0;
        int current=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            current=Math.min(n3,Math.min(n2,n5));
            dp[i]=current;
            if(current==n2){
                n2*=2;
            }
        }
        return current;
    }
    public static void main(String args[]){
        System.out.println(nthUglyNumber(10));
    }
}