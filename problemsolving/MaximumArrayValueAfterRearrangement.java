
import java.util.Arrays;

public class MaximumArrayValueAfterRearrangement {

    static int Maximize(int arr[]) {
        // Complete the function
        Arrays.sort(arr);
        long res=0;
        for(int i=1;i<arr.length;i++){
            res=(res+((long)i*arr[i])%1000000007)%1000000007;
        }
        return (int)res;
    }
    public static void main(String args[]){
        System.out.println(Maximize(new int[]{}));
    }
}
