import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumber {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(3);
        array.add(7);
        Collections.sort(array);
        System.out.println(lonelyNumber(array));

    }
    public static ArrayList<Integer> lonelyNumber(ArrayList<Integer> list){
        ArrayList<Integer> result=new ArrayList<>();
        if(list.size()==1){
            result.add(list.get(0));
        }
        if (list.size() > 1) {
            if (list.get(0) < list.get(1)) {
                result.add(list.get(0));
            }
            if (list.get(list.size()-2) < list.get(list.size()-1)) {
                result.add(list.get(list.size()-1));
            }
        }
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i-1)<list.get(i) && list.get(i)<list.get(i+1)){
            result.add(list.get(i));
            }
        }
        
        return result;
    }
}
