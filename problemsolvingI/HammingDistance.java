
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        String a=Integer.toBinaryString(x);
        String b=Integer.toBinaryString(y);
        System.out.println(a);
        System.out.println(b);
        int res=0;
        return res;
    }
    public static void main(String args[]){
        System.out.println(hammingDistance(1,4));
    }
}
