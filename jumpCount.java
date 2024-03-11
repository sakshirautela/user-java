import java.util.Scanner;
public class jumpCount {
 
     static int path(int m , int n) {
         if(m==1 || n==1) 
             return 1;
         
         return path(m-1,n)+path(m,n-1);
     }
    public static void main(String[] args) {
     
         System.out.println(path(4,4));
        
    }
 
}