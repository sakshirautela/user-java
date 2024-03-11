public class BitOperations {
    static public void EvenOdd(int n){
        if((n & 1)==0){
            System.out.println("even");

        }
        else{
            System.out.println("odd");

        }
    }
    public static int  setbit(int n, int i){
        int bitMask = 1 << i;
        return n | bitMask;
    }
    public static void getbit(int n,int pos){
        int bitMask=1<<pos;
        if((n & bitMask)==0){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    public static void main(String[] args) {
        //getbit(3,2);
        //System.out.println(setbit(4, 2));
        EvenOdd(5);
    }
}
