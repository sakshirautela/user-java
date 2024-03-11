import java.util.Scanner;
public class PeriodicalNumbers {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int i=1;i<=t;i++){
      int a=sc.nextInt();
      int b=sc.nextInt();
      int count=0;
      int r=0;
      if(a==b)
        r=count;
      else if( a%2==0 && b%2==0 && a>b ){
        r=1;
      }  else if( a%2==0 && b%2==0 && a<b ){
        r=2;
      }  else if( a%2==0 && b%2==1 && a>b ){
        r=2;
      }  else if( a%2==0 && b%2==1 && a<b ){
        r=1;
      }  else if( a%2==1 && b%2==0 && a>b ){
        r=2;
      }  else if( a%2==1 && b%2==0 && a<b ){
        r=1;
      }  else if( a%2==1 && b%2==1 && a>b ){
        r=1;
      }  else if( a%2==1 && b%2==1 && a<b ){
        r=2;
      }
      System.out.println(r);
    }
  }
}