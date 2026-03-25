import java.util.Arrays;
import java.util.Set;

public class LargestNumberInOneSwap {
    static void main() {
        System.out.println(largestSwap("968"));
    }

    public static String largestSwap(String s) {
        // code here
        char[] arr=s.toCharArray();
        int n=arr.length;
        int right=-1;
        int left=-1;
        int idx=-1;
        char rightVal='0';
        for(int i=n-1;i>=0;i--){
            if(arr[i]>rightVal){
                rightVal=arr[i];
                idx=i;
            }else if(arr[i]<rightVal){
                left=i;
                right =idx;
            }
        }
        char temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}