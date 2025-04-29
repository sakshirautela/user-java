
import java.util.Arrays;

public class MergeWithoutExtraSpaceGFG {
    public static void main(String[] args) {
        int[] a={};
        int[] b={};
        mergeArrays(a,b);
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : b) {
            System.out.print(i+" ");
        }
    }
    // Function to merge the arrays.
    public static void mergeArrays(int a[], int b[]) {
        // code here'
        int m=a.length;
        int n=b.length;
        int i=m-1;
        int j=0;
        while (i>=0 && j<n) {
            if(b[j]<a[i]){
                int temp=a[i];
                a[i]=b[j];
                b[j]=temp;
                i--;
                j++;
            }else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
