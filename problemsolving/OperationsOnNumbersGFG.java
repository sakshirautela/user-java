
public class OperationsOnNumbersGFG {
    public static long minOps(long a, long b) {
        // code here
        long res=minOpsHelper(a, b,0);
        if(res==Long.MAX_VALUE){
            return -1;
        }
        return res;
    }
    private static long minOpsHelper(long a, long b, long i) {
        if(a>b){
            return Long.MAX_VALUE;
        }if(a==b){
            return i;
        }
        long s=(long) Math.sqrt(b);
        long n=Long.MAX_VALUE;
        if(s*s==b && s>=a){
            n=minOpsHelper(a, s,i+1);
        }
        return Math.min(n,minOpsHelper(a, b-1, i+1));
    }
    public static void main(String[] args) {
        System.out.println(minOps(2,5));
    }
}
