import java.util.*;

public class ArithmeticProgression {
    // public static List<Integer> getArithmeticProgression(int a,int l,int d){
    //     List<Integer> result = new ArrayList<Integer>();
    //     while(a<=l){
    //         result.add(a);
    //         a+=d;
    //     }
    //     return result;
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        int n=scanner.nextInt();
        int d=scanner.nextInt();
        while(a<=n){
            System.out.println(a+" ");
            a+=d;
        }
    }
}
