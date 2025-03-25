public class KoKoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {}, 7));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        int sum=0;
        for (int i : piles) {
            sum+=i;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int required = sum/mid;
            if(required<h){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }

}