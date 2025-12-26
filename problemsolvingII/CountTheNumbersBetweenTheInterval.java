public class CountTheNumbersBetweenTheInterval {
    public static void main(String[] args) {
        System.out.println(countOdds(3, 6));
    }

    public static int countOdds(int low, int high) {
        int n = high - low - 1;
        if(low%2==0 && high%2==0){
            return n/2+1;
        }else if(low%2==1 && high%2==1){
            return n/2+2;
        }else{
            return n/2+1;
        }
    }
    public int countOdds2(int low, int high) {
        int range=high-low+1;
        if(low%2==1 && high%2==1){
            return (range/2)+1;
        }
        return range/2;

    }
}
