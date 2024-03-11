import java.util.Arrays;

public class minAbsoluteDifference {
    public static void main(String[] args) {
        int[] A={1,2,3};
        int[] B={2,1,3};
        System.out.println(absDiff(A, B));
    }
    public static int absDiff(int[] A,int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int ab=0;
        for (int i = 0; i < B.length; i++) {
            int curr= A[i]-B[i] ; // or we can Use Math.abs(A[i]-B[i]) to get absolute differnce
            if(curr<0){
                curr=curr*(-1);
            }
            ab+=curr;
        }
        return ab;
    }
}
