import java.util.Arrays;
import java.util.Comparator;

public class maxLengthOfChainOfPairs {
    public static void main(String[] args) {
        int[][] A={{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(A,Comparator.comparing(O -> O[1]));
        int last=A[0][1];
        int totalPairs=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i][0]>last){
                totalPairs++;
                last=A[i][0];
            }
        }
        System.out.println(totalPairs);
    }
}
