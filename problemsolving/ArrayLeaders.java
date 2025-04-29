
import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    public static void main(String[] args) {
        System.out.println(leaders(new int[]{16, 17, 4, 3, 5, 2}));
    }
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> li=new ArrayList<>();
        int rightMax=arr[arr.length-1];
        li.add(rightMax);
        for (int i =  arr.length-2;i>=0; i--) {
            if(arr[i]>rightMax){
                rightMax=arr[i];
                li.add(rightMax);
            }
        }
        Collections.reverse(li);
        return li;
    }
}
