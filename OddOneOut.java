import java.util.*;
public class OddOneOut{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int num1,num2,num3;
        for(int i=0; i<n; i++){
            num1=scanner.nextInt();            
            num2=scanner.nextInt();
            num3=scanner.nextInt();
            if(num1!=num2 && num1!=num3){
                System.out.println(num1);
            }else if(num2!=num3 && num2!=num1){
                System.out.println(num2);
            }else{
                System.out.println(num3);
            }

        }
    }
}