import java.util.Scanner;

class java
{
    public static void main(String args[]) {
        int a;
        System.out.println("enter a number");
        Scanner obj =new Scanner(System.in);
        a=obj.nextInt();
        System.out.println(a);
        int f=1, i=2;
        while(++i<5)
            f*=i;
        System.out.println(f);
        
    }
}