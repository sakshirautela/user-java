import java.util.*;

// main function 
class sol{
    static void main(){
        ArrayList<Integer> arr =new ArrayList<>();
    }
}

class Solution{
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