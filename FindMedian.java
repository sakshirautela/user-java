import java.util.Arrays;
public class FindMedian {
    public static int[] findMedian(int[] arr, int n) {
        if(n==1){
            return new int[]{arr[0]};
        }
        
        int a=(int)(n/2);
        Arrays.sort(arr);
        if(n%2!=0){
            return new int[]{arr[a]};
        }
        else{
            return new int[]{(arr[a]+arr[a-1])/2};
        }
    }
    public static void main(String...args){
        int arr[]={6,10,2,6};//,5};//,0,6,3,1,0,0};
        int[] res=(findMedian(arr, arr.length));
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
