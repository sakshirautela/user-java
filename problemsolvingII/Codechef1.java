import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int even=0,odd=0;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if(num%2==0){
                    even++;
                }else {
                    odd++;
                }
            }
            if (odd%2==0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void applyFun(int[] arr, int n) {
    }
}
