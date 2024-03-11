public class MyPower {
    public static  double myPow(double x,long n) {
        double pow;
        double temp;
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }
        if(n<0){
            return myPow((1/x),-n);
        }
        else{
            temp=myPow(x,n/2);
            if(n%2==1){
                pow=temp*temp*x;
            }
            else{
                pow=temp*temp;
            }
        }
        return pow;
    }
    public static void main(String[] args) {
        int n=-2;
        double x=5.0;
        System.out.println(myPow(x,n));
    }
}