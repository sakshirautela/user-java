public class NcR{
    public static void main(String[] args){
        System.out.println(nCr(21,16));
    }
    public static int nCr(int n, int r) {
        // code here
        if(r>n){
            return 0;
        }
        double result=1;
        for (int i = 1; i <=r; i++) {
            result=result*(n-r+i)/i;
        }
        return (int) result;
    }
}