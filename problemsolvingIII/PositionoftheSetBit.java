package problemsolvingIII;

public class PositionoftheSetBit {
    static void main() {
        System.out.println(findPosition(4));
    }

    public static int findPosition(int n) {
        // code here
        double z=Math.log(n)/Math.log(2);
        double s=Math.round(z);
        if(z==s){
            return (int) z+1;
        }
        return -1;
    }
}
