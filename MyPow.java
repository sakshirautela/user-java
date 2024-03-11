public class MyPow {
    public static  double myPow(double x, int n) {
        double pow;
        double temp;
        if(n==0){
            return 1;
        }
        temp=myPow(x,n/2);
        if(n%2==1){
            if(n<0){
                pow=1/(temp*temp*x);
            }
            pow= temp*temp*x;
        }
        else{
            if(n<0){
                pow=1/(temp*temp);
            }
            pow=temp*temp; 
        }
        return pow;
    }
    public static void main(String[] args) {
        int n=2;
        double x=5.0;
        myPow(x,n);
    }
}