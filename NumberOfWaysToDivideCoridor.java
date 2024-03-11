public class NumberOfWaysToDivideCoridor {
    static final int mod=100000007;
    public static int numberOfWays(String corridor) {
        int count = 0;
        int ways = 1,prevIdx = -1;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                count++;
                if(count>2 && count%2==1){
                    ways=(ways*(i-prevIdx))%mod;
                }
                prevIdx=i;
            }
        }
        return (count>0 && count%2==0)?ways:0;
    }
    public static void main(String[] args) {
        System.out.println(numberOfWays("SSPPSPS"));
    }
}