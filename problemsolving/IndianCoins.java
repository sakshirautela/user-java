import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer[] A={2,1,5,10,20,100,50,200,500,2000};
        Arrays.sort(A,Comparator.reverseOrder());
        
        int amount=4000;
        int count=0;
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i]<=amount){
                while (A[i]<=amount) {
                    count++;
                    res.add(A[i]);
                    amount-=A[i];
                }
            }
        }
        System.out.println(count);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
