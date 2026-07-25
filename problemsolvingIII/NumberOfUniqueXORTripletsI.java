package problemsolvingIII;

public class NumberOfUniqueXORTripletsI {
    static void main() {
        System.out.println(uniqueXorTriplets2(new int[]{}));
    }
        public int uniqueXorTriplets(int[] nums) {
            int n=nums.length;
            if(n<=2){
                return n;
            }
            int msb=0;
            while(n>0){
                n>>=1;
                msb++;
            }
            System.out.println(msb);
            return 1<<(msb);
    }
        public  static int uniqueXorTriplets2(int[] nums) {
            int n = nums.length;
            if(n < 3) return n;
            int nearest = (int)(Math.log(n)/Math.log(2));
            return 1 << (nearest + 1);
        }
}
