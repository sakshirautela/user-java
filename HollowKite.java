import java.util.Scanner;
class HollowKite{
    
    public static void main(String[] args){
       // System.out.println("hello");
       Scanner obj = new Scanner(System.in);
       int n= obj.nextInt();
       int i,j;
       for(i=1;i<n;i++){
        for(j=1;j<n-i;j++){
            System.out.print(" ");
        }
        for(j=1;j<2*n+1;j++){
            if( j==1 || j==(2*i-1)){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
        }
        
        System.out.println();
       }
       for(i=n-2;i>=1;i--){
        for(j=1;j<n-i;j++){
            System.out.print(" ");
        }
        for(j=1;j<2*n+1;j++){
            if( j==1 || j==(2*i-1)){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
        }
        
        System.out.println();
       }
    }
}