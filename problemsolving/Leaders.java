
import java.util.*;

// main function 

public class Leaders{
       public static void main(String args[]){
            System.out.println(leaders(new int[]{16,17,4,3,5,2},6));
    }
    // function to find leaders 
    static ArrayList<Integer> leaders(int[] arr,int n){
        int max=arr[n-1];
        ArrayList<Integer> result =new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=max){
                result.add(max);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
