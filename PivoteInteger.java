
public class PivoteInteger {

    public static int pivotInteger(int n) {
        double x = Math.sqrt(n * (n + 1) / 2);

        if (x % 1 != 0) {
            return -1;
        } else {
            return (int) Math.floor(x);
        }
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(6));
    }
}
