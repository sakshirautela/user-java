public class ImplementPowGFG {
    public static void main(String[] args) {
        System.out.println(power(0.55000, 3));
    }

    static double power(double x, int n) {
        // code here
        double pow;
        double temp;
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }
        if(n<0){
            return power((1/x),-n);
        }
        else{
            temp=power(x,n/2);
            if(n%2==1){
                pow=temp*temp*x;
            }
            else{
                pow=temp*temp;
            }
        }
        return pow;
    }
}
