import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConsecutivePrimeSum {
    public static void main(String[] args) {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int n=100000;
        int result = countprimesum(n);
        System.out.println(result);
        sc.close();
    }

    private static int countprimesum(int n) {
        int lim = (int) 1e5;
        boolean isprime[] = new boolean[lim + 1];
        Arrays.fill(isprime,true);
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i * i <= lim; i++) {
            if (isprime[i]) {
                for (int j = i*i; j <lim ; j+=i) {
                    isprime[j]=false;
                }
            }
        }
        for(int i=2;i<=lim;i++){
            if(isprime[i])
                prime.add(i);
        }
        int sum=5;
        int idx=2;
        int res=0;
        while (sum<=n){
            if(isprime[sum]){
                res++;
            }
            sum+=prime.get(idx);
            idx++;
        }
        return res;
    }
}