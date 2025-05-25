public class CorporateFlightBookings {
    public static void main(String[] args) {
        int[] res=corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5);
        for (int i : res) {
            System.err.print(i+" ");
        }
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff=new int[n+1];
        for (int[] b : bookings) {
            diff[b[0]-1]+=b[2];
            diff[b[1]]-=b[2];
        }
        int[] res=new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=diff[i];
            res[i]=sum;
        }
        return res;
    }
}