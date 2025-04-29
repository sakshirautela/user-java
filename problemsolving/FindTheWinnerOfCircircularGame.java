
import java.util.ArrayList;

public class FindTheWinnerOfCircircularGame {
    public static  int findTheWinner(int n, int k) {
        ArrayList<Integer> arr=new ArrayList();
        for(int i=0;i<n;i++){
            arr.add(i+1);
        }
        int idx=0;
        while(arr.size()>1){
            idx=(idx+k-1)%arr.size();
            arr.remove(idx);
        }
        return arr.get(0);
    }
    public static void main(String args[]){
        System.out.println(findTheWinner(5,2));
    }
}
