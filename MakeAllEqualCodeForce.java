import java.util.Arrays;
import java.util.Scanner;
 
public class MakeAllEqualCodeForce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        while(n>0){
            int  d = scanner.nextInt();
            int[] arr = new int[d];
            for (int i = 0; i < d; i++) {
                int a = scanner.nextInt();
                arr[i] = a;
            }
            int max=0;
            for(int i:arr){
                max=Math.max(max,i);
            }
            int counSort[]=new int[max+1];
            for(int i:arr){
                counSort[i]++;
            }
            int r=0;
            for(int i=0;i<max+1;i++){
                if(counSort[i]>max){
                    max=counSort[i];
                    r=i;
                }
            }
            System.out.println(arr.length-r);
            n--;
        }
    }
}