import java.util.ArrayList;

public class MaximumEarningFromTaxiRides {
    public static void main(String[] args) {
        System.out.println(maxTaxiEarnings(8, new int[][] { {} }));
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        long dp[] = new long[n + 1];
        ArrayList<ArrayList<int[]>> endofride = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            endofride.add(new ArrayList<>());
        }
        for (int[] ride : rides) {
            endofride.get(ride[1]).add(ride);
        }
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1];
            for(int[] ride:endofride.get(i)){
                dp[i]=Math.max(dp[i],dp[ride[0]]+ride[1]-ride[0]+ride[2]);
            }
        }
        return dp[n];
    }
   /* public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b) -> a[0]-b[0]);
        long memo[] = new long[rides.length];
        return findMaximumEarningsForRide(rides,0, memo);
    }

    public long findMaximumEarningsForRide(int[][] rides, int i, long memo[]){
        if(i>=rides.length){
            return 0;
        }

        if(memo[i]!=0){
            return memo[i];
        }
        
        int[] ride = rides[i];
        int start=ride[0], end=ride[1], tip=ride[2];
        int nextRide=findNextRide(rides, i);
        long earnings=(end-start)+tip+findMaximumEarningsForRide(rides, nextRide,memo);
        long earningsWithoutCurrentRide=findMaximumEarningsForRide(rides, i+1,memo);
        long maxEarnings=Math.max(earnings,earningsWithoutCurrentRide);
        memo[i]=maxEarnings;
        return maxEarnings;
    }

    public int findNextRide(int[][] rides, int i){
        int l=i+1;
        int r=rides.length-1;
        int end=rides[i][1];

        while(l<=r){
            int m=l+(r-l)/2;
            if(rides[m][0]>=end){
                r=m-1;
            }else{
                l=m+1;
            }
        }return l;
    }*/

    public static class Ride{
        final int start;
        final int tip;
        final Ride next;
        public Ride(int start,int tip, Ride next){
            this.start=start;
            this.tip=tip;
            this.next=next;
        }
    }

    public long maxTaxiEarningsFast(int n, int[][] rides) {
        Ride[] rideCycle = new Ride[n+1];
        for(int[] ride:rides){
            rideCycle[ride[1]]=new Ride(ride[0],(ride[1]-ride[0])+ride[2],rideCycle[ride[1]]);
        }

      /* for(int i=1; i<=n; i++){
            System.out.println(i);
            if(rideCycle[i]!=null){
            System.out.println(rideCycle[i].start+" "+rideCycle[i].tip);
            Ride nx=rideCycle[i].next;
            if(nx!=null){
                 System.out.println(nx.start+" "+nx.tip);
                 Ride nx1=nx.next;
            if(nx1!=null){
                 System.out.println("nx1"+nx1.start+" "+nx1.tip);
            }
            }
            }
        }*/

        long maxEarnings=0;
        long[] max = new long[n+1];
        for(int i=1;i<=n;i++){            
            for(Ride r=rideCycle[i];r!=null;r=r.next){
                //System.out.println(i+" "+r.start+" "+r.tip);
                maxEarnings=Math.max(r.tip+max[r.start],maxEarnings);
            }
            max[i]=maxEarnings;
           // System.out.println(i+" "+max[i]);
        }
        return maxEarnings;
    }
}