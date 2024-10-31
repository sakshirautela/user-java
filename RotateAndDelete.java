import java.util.ArrayList;
import java.util.Arrays;
public class RotateAndDelete {
    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        int k=1;
        int n=arr.size();
        while (k<n) {
            int s=arr.size();
            int rem=arr.get(s-1);
            arr.remove(s-1);
            arr.add(0,rem);
            if(s-k<0){
                arr.remove(0);
            }else{
                arr.remove(s-k);
            }
            k++;
        }
        return arr.get(0);
    }
    public static void main(String[] args){
        System.out.println(rotateDelete(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6))));
    }
}
