import java.util.Arrays;
import java.util.Collections;

public class Tester {
    public static void main(String[] args) {
        int sum=0;
       int[] arr = new int[] {1, 2, 6, 4, 5};
       Arrays.sort(arr);
       Collections.reverse(Arrays.asList(arr));
 
        // Reversing the array
        //reverse(arr);
       for (int i = 0; i < arr.length; i++) {
        // for (int j = i; j < arr.length; j++) {
        // sum=0;
        //   for (int k = i; k <= j; k++) {
        //     System.out.print(arr[k] );
        //     sum=sum+arr[k];
            
        //   }
        //   System.out.println();
          System.out.println(arr[i]);
        }
      }

    }
