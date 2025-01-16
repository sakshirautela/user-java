import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SplitArrayinThreeEqualSumSubarrays {
    public static List<Integer> findSplit(int[] arr) {
        // code here
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int rem=sum;
        List<Integer> l = new ArrayList<Integer>();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += arr[i];
            if (temp == sum / 3) {
                rem-=sum/3;
                l.add(i);
                if(l.size()==2 && sum/3==rem){
                    return l;
                }
                temp=0;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(-1,-1));
    }

    public static void main(String args[]) {
        System.out.print(findSplit(new int[] { 0,0,0,0 }));
    }
}