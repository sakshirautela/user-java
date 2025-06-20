
import java.util.*;
public class sumPrime {
    public static int isPrime(int n){
        //boolean true ;
        for(int i=2;i<n;i++){
            if(n%i==0){
                return 0;
            }
        }
        return 1;
    }
    public static int main(String[] args) {
        int sum=0;
        Scanner obj=new Scanner(System.in);
        int n =obj.nextInt();
        for(int i=2;i<n;i++){
            sum+=i;
            if(isPrime(sum)==1){
                System.out.println(sum);
            }
            else{
                System.out.print(2);
            }           
        }
        obj.close();
        return sum;
    }
}

