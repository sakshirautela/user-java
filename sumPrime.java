import java.util.*;
public class sumPrime {
    public int isPrime(int n){
        //boolean true ;
        for(int i=2;i<n;i++){
            if(n%i==0){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static int main(String[] args) {
        int sum=0;
        Scanner obj=new Scanner(System.in);
        int n =obj.nextInt();
        for(int i=2;i<n;i++){
            sum+=i;
            if(isPrime(sum)){
                System.out.println(sum);
            }
            else{
                System.out.printl(2)
            }           
        }
    }
}

