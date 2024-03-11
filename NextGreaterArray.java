import java.sql.Array;
import java.util.Stack;

public class NextGreaterArray {
    public static void main(String[] args) {
        int[] array = { 6, 8, 0, 1, 3 };
        //next greater right
        int[] res = new int[array.length];
        Stack<Integer> s = new Stack<>();
        for (int i = res.length-1;i>=0 ;i--) {
            int curr=array[i];
            while(!s.empty() && curr>=array[s.peek()]){
                s.pop();
            }
            if(s.empty()){
                res[i]=-1;
            }
            else{
                res[i] = array[s.peek()];
            }
            s.push(i);
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
        
        // next greater left


        // next smaller right

        // next smaller left

    }
}
