import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetExample{
    public static void main(String[] args) {
        ArrayList list = new   ArrayList();
        HashSet<List<Integer>> set=new HashSet<>();
        for(int i=0;i<4;i++){
            list.add(23);
            list.add(45);
            list.add(23);
            list.add(2);

        }
        set.addAll(list);
        System.out.println(set);
    }
}