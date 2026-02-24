import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlusMinusSplit {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if(a%2==0){
                    even.add(a);
                }else{
                    odd.add(a);
                }
            }
            if(even.size()==n || odd.size()==n){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
